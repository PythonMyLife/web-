package spring.books;

import spring.books.bookMapper;
import spring.books.book;
import spring.books.bookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class bookServiceImpl implements bookService{
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
}
