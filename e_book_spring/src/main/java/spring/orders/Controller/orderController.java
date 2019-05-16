package spring.orders.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import spring.orders.Model.order;
import spring.orders.Model.item;
import spring.orders.Service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/ebook")
public class orderController {

    @Autowired
    orderService order_serv;

    @RequestMapping(value = "/submit_order",method = RequestMethod.GET)
    @ResponseBody
    public String submit(String username){
        System.out.println("提交订单"+username);
        String result = order_serv.signup_order(username);
        System.out.println(result);
        return result;
    }

    @RequestMapping(value = "/all_orders",method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<order> orders(@RequestBody Map map){
        String username = (String)map.get("username");
        System.out.println("全部订单"+username);
        ArrayList<order> orders= order_serv.getall_orders(username);
        return orders;
    }

    @RequestMapping(value = "/getOrders",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<order> getOrders(){
        ArrayList<order> orders= order_serv.getOrders();
        return orders;
    }

}
