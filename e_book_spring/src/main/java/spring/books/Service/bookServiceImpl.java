package spring.books.Service;

import org.springframework.jdbc.core.RowCallbackHandler;
import spring.books.Model.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import spring.books.Dao.bookMapper;
import spring.books.Service.bookService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class bookServiceImpl implements bookService {
    @Autowired
    private JdbcTemplate jdbc_tem;

    @Override
    public void insert(book book){
        jdbc_tem.update("insert into books(bookname,author,cover,ISBN,num,price) values (?,?,?,?,?,?)",
                book.getBookname(),book.getAuthor(),book.getCover(),book.getISBN(),book.getNum(),book.getPrice());
    }

    @Override
    public void delete(String ISBN){
        jdbc_tem.update("delete from books where ISBN= ?",ISBN);
    }

    @Override
    public book search(String ISBN){
        return jdbc_tem.queryForObject("SELECT * FROM BOOKS WHERE ISBN = ?", new bookMapper(), ISBN);
    }
    @Override
    public ArrayList<book> getall_books(){
        String sql = "SELECT * FROM BOOKS";
        ArrayList<book> booklist = new ArrayList<>();
        jdbc_tem.query(sql, new Object[]{}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                book book = new book();
                book.setBookname(resultSet.getString("bookname"));
                book.setAuthor(resultSet.getString("Author"));
                book.setCover(resultSet.getString("cover"));
                book.setISBN(resultSet.getString("ISBN"));
                book.setNum(resultSet.getInt("num"));
                book.setPrice(resultSet.getDouble("price"));
                booklist.add(book);
            }
        });
        return booklist;
    }

}
