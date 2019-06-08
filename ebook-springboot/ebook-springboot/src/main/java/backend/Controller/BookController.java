package backend.Controller;


import backend.Entity.Book;
import backend.Entity.BookMongoDB;
import backend.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ebook")
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> allBooks(){
        List<Book> bookList = bookService.findAllBook();
        return bookList;
    }

    @RequestMapping(value="/subpage", method = RequestMethod.GET)
    @ResponseBody
    public String subpage(String isbn){
        return bookService.findByIsbn(isbn).getDetail();
    }

    @RequestMapping(value="/getcomments", method = RequestMethod.GET)
    @ResponseBody
    public BookMongoDB getComments(String isbn){
        return bookService.findMongodbByIsbn(isbn);
    }

    @RequestMapping(value="/addcomment", method = RequestMethod.POST)
    @ResponseBody
    public boolean addComment(@RequestBody Map map){
        String isbn = (String) map.get("isbn");
        String comment = (String) map.get("comment");
        return bookService.addComment(isbn, comment);
    }

}
