package spring.users.Service;

import spring.users.Model.user;
import spring.users.Dao.userMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import org.springframework.jdbc.core.RowCallbackHandler;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private JdbcTemplate jdbc_tem;

    @Override
    public void changeStatus(String username){
        user user_change = jdbc_tem.queryForObject("SELECT * FROM users WHERE username = ?", new userMapper(), username);
        jdbc_tem.update("update users set status=? where username=?",(1-user_change.getStatus()),username);
    }

    @Override
    public ArrayList<user> getUsers(){
        String sql = "SELECT * FROM users WHERE identity <> 1";
        List<user> userlist = jdbc_tem.query(sql, new userMapper());
        return (ArrayList<user>) userlist;
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
