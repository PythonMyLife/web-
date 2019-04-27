package spring.users.Service;

import spring.users.Model.user;
import spring.users.Dao.userMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import org.springframework.jdbc.core.RowCallbackHandler;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private JdbcTemplate jdbc_tem;

    @Override
    public void change_status(String username){
        user user_change = jdbc_tem.queryForObject("SELECT * FROM users WHERE username = ?", new userMapper(), username);
        jdbc_tem.update("insert into users(username,password,email,status,identity) values (?,?,?,?,?)",
                user_change.getUsername(),user_change.getPassword(),user_change.getEmail(),user_change.getStatus(),1-user_change.getIdentity());
    }

    @Override
    public ArrayList<user> getall_users(){
        String sql = "SELECT * FROM users";
        ArrayList<user> userlist = new ArrayList<>();
        jdbc_tem.query(sql, new Object[]{}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user user = new user();
                user.setUsername(resultSet.getString("username"));
                //user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setStatus(resultSet.getInt("status"));
                user.setIdentity(resultSet.getInt("identity"));
                userlist.add(user);
            }
        });
        return userlist;
    }

    @Override
    public Integer identity(String username, String password){
        Integer id = -1;
        try {
            user user_search = jdbc_tem.queryForObject("SELECT * FROM users WHERE username = ?", new userMapper(), username);
        if((user_search == null) || !(user_search.getPassword().equals(password))){
            id = -1;
        }else if((user_search.getIdentity() == 0)&&(user_search.getStatus() == 0)){
            id = 0;
        }else if((user_search.getIdentity() == 0)&&(user_search.getStatus() == 1)){
            id = 2;
        }else if(user_search.getIdentity() == 1){
            id = 1;
        }}catch (Exception e){
            id = -1;
        }
        return id;
    }

    @Override
    public Integer regist(String username, String password, String email){
        Integer flag = 0;
        try {
            user user_search = jdbc_tem.queryForObject("SELECT * FROM users WHERE username = ?", new userMapper(), username);
            if(user_search != null) {
                return flag;
            }
            }catch (Exception e){
            flag = 1;
            jdbc_tem.update("insert into users(username,password,email,status,identity) values (?,?,?,?,?)",username,password,email,0,0);
        }
        return flag;
    }
}
