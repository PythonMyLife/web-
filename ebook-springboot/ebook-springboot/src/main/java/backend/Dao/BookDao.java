package backend.Dao;

import backend.Entity.Book;

import java.util.List;

public interface BookDao {

    void save(Book book);
    //得到全部的书
    List<Book> findAll();

    //得到库存不为0的书
    List<Book> findAllByNumValid();

    //得到一本书
    Book findByIsbn(String isbn);

    //增加一本书
    Boolean addBook(Book book);

    //删除一本书
    void deleteBook(String isbn);

    //设置一本书的数量
    void setBookNum(Book book, Integer num);
}
