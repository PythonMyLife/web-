package backend.ServiceImpl;


import backend.Dao.BookDao;
import backend.Entity.Book;
import backend.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> findAllBook(){
        return bookDao.findAll();
    }

    @Override
    public Book findByIsbn(String isbn){
        return bookDao.findByIsbn(isbn);
    }
}
