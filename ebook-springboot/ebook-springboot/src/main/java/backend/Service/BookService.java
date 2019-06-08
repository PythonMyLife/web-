package backend.Service;

import backend.Entity.Book;
import backend.Entity.BookMongoDB;

import java.util.List;

public interface BookService {
    //得到所有的书
    List<Book> findAllBook();

    //通过isbn查找一本书
    Book findByIsbn(String isbn);

    //通过isbn得到一本书的书评
    BookMongoDB findMongodbByIsbn(String isbn);

    //添加书评
    Boolean addComment(String isbn, String comment);
}
