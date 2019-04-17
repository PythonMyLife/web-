package spring.books;

import spring.books.bookService;
import spring.books.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class bookController {

    @Autowired
    bookService book_serv;

    @RequestMapping(value = "/re",method = RequestMethod.GET)
    @ResponseBody
    public book pass(){
        book book = book_serv.search("9787111544937");
        System.out.println("执行完成");
        return book;
    }
}
