package spring.users.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import spring.users.Model.user;
import org.springframework.jdbc.core.RowMapper;

public class userMapper implements RowMapper<user> {
    @Override
    public user mapRow(ResultSet resultSet, int i) throws SQLException {
        /*获取结果集中的数据 */
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String email = resultSet.getString("email");
        Integer status = resultSet.getInt("status");
        Integer identity = resultSet.getInt("identity");
        /*把数据封装成User对象 */
        return new user(username, password, email, status, identity);
    }
}
