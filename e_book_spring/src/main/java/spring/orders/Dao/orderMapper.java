package spring.orders.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import spring.orders.Model.order;


public class orderMapper implements RowMapper<order> {
    @Override
    public order mapRow(ResultSet resultSet, int i) throws SQLException {
        /*获取结果集中的数据 */
        String order_id = resultSet.getString("order_id");
        String cover = resultSet.getString("cover");
        String bookname = resultSet.getString("bookname");
        String username = resultSet.getString("username");
        String time = resultSet.getString("time");
        Integer status = resultSet.getInt("status");
        String ISBN = resultSet.getString("ISBN");
        Integer number = resultSet.getInt("number");
        Double totalAmount = resultSet.getDouble("totalAmount");
        /*把数据封装成order对象 */
        return new order(order_id, bookname, cover, username, time, status, ISBN, number, totalAmount);
    }
}
