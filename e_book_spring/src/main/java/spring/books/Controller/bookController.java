package spring.books.Controller;

import spring.books.Model.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.books.Service.bookService;

import java.util.ArrayList;

@Controller
@RequestMapping("/ebook")
public class bookController {

    @Autowired
    bookService book_serv;

    @RequestMapping(value = "/books",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<book> pass(){
        ArrayList<book> booklist = book_serv.getall_books();
        System.out.println("执行完成");
        return booklist;
    }
}
