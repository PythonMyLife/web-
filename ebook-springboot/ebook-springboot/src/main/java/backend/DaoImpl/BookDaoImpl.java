package backend.DaoImpl;


import backend.Dao.BookDao;
import backend.Entity.Book;
import backend.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @Override
    public Book findByIsbn(String isbn){
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public Boolean addBook(Book book){
        if(bookRepository.save(book) != null)
            return true;
        return false;
    }

    @Override
    public void deleteBook(String isbn){
        bookRepository.deleteByIsbn(isbn);
    }
}