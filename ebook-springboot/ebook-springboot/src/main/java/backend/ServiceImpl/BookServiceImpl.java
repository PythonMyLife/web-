package backend.ServiceImpl;


import backend.Dao.BookDao;
import backend.Dao.BookMongoDBDao;
import backend.Entity.Book;
import backend.Entity.BookMongoDB;
import backend.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Autowired
    private BookMongoDBDao bookMongoDBDao;

    @Override
    public List<Book> findAllBook(){
        return bookDao.findAll();
    }

    @Override
    public Book findByIsbn(String isbn){
        return bookDao.findByIsbn(isbn);
    }

    @Override
    public BookMongoDB findMongodbByIsbn(String isbn){
        return bookMongoDBDao.findByIsbn(isbn);
    }

    @Override
    public Boolean addComment(String isbn, String comment){
        try{
            BookMongoDB bookMongoDB = bookMongoDBDao.findByIsbn(isbn);
            List<String> comments = bookMongoDB.getComments();
            comments.add(comment);
            bookMongoDB.setComments(comments);
            bookMongoDBDao.save(bookMongoDB);
            return true;
        }catch (Exception e){
            try{
                BookMongoDB bookMongoDB = new BookMongoDB();
                bookMongoDB.setIsbn(isbn);
                ArrayList<String> comments = new ArrayList<>();
                comments.add(comment);
                bookMongoDB.setComments(comments);
                bookMongoDBDao.save(bookMongoDB);
                return true;
            }catch (Exception ex){
                System.out.println(isbn);
                System.out.println(comment);
                return false;
            }
        }
    }
}
