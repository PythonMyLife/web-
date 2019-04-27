package spring.carts.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import spring.carts.Model.cart;
import org.springframework.jdbc.core.RowMapper;

public class cartMapper implements RowMapper<cart>{
    @Override
    public cart mapRow(ResultSet resultSet, int i) throws SQLException {
        /*获取结果集中的数据 */
        String bookname = resultSet.getString("bookname");
        String username = resultSet.getString("username");
        String cover = resultSet.getString("cover");
        Double price = resultSet.getDouble("price");
        Integer number = resultSet.getInt("number");
        String ISBN = resultSet.getString("ISBN");
        /*把数据封装成User对象 */
        return new cart(bookname, username, cover, price, number, ISBN);
    }
}
