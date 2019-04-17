package spring.books;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import spring.books.book;
import org.springframework.jdbc.core.RowMapper;

/**
 * 实现RowMapper接口，返回user对象
 */
public class bookMapper implements RowMapper<book>{
    @Override
    public book mapRow(ResultSet resultSet, int i) throws SQLException {
        /*获取结果集中的数据 */
        String bookname = resultSet.getString("bookname");
        String author = resultSet.getString("author");
        String cover = resultSet.getString("cover");
        String ISBN = resultSet.getString("ISBN");
        Integer num = resultSet.getInt("num");
        Double price = resultSet.getDouble("price");
        /*把数据封装成User对象 */
        return new book(bookname, author, cover, ISBN, num, price);
    }
}
