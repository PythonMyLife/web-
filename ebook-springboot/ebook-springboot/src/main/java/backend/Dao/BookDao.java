package backend.Dao;

import backend.Entity.Book;

import java.util.List;

public interface BookDao {
    //得到全部的书
    List<Book> findAll();

    //得到一本书
    Book findByIsbn(String isbn);

    //增加一本书
    Boolean addBook(Book book);

    //删除一本书
    void deleteBook(String isbn);
}
