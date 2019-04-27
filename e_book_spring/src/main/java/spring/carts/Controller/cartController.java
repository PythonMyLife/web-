package spring.carts.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import spring.carts.Model.cart;
import spring.carts.Service.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/ebook")
public class cartController {
    @Autowired
    cartService cart_serv;

    @RequestMapping(value = "/carts",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<cart> pass(String username){
        System.out.println("传参为:");
        System.out.println(username);
        ArrayList<cart> cartlist = cart_serv.getall_carts(username);
        System.out.println("执行完成");
        return cartlist;
    }

    @RequestMapping(value = "/carts/change_book", method = RequestMethod.POST)
    @ResponseBody
    public void change_book(@RequestBody Map map){
        System.out.println(map);
        String username = (String)map.get("username");
        String ISBN = (String)map.get("ISBN");
        Integer number = (Integer)map.get("number");
        System.out.println(number);
        cart_serv.update_book(username, ISBN, number);
    }

    @RequestMapping(value = "/carts/handle_delete", method = RequestMethod.POST)
    @ResponseBody
    public void handle_delete(@RequestBody Map map){
        System.out.println(map);
        String username = (String)map.get("username");
        String ISBN = (String)map.get("ISBN");
        cart_serv.delete_book(username, ISBN);
    }

    @RequestMapping(value = "/carts/add_book", method = RequestMethod.POST)
    @ResponseBody
    public void add_book(@RequestBody Map map){
        System.out.println(map);
        String username = (String)map.get("username");
        String ISBN = (String)map.get("ISBN");
        cart_serv.add_book(username, ISBN);
    }
}
