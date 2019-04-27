package spring.users.Controller;

import org.springframework.web.bind.annotation.*;
import spring.users.Service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
@RequestMapping("/ebook")
public class userController {

    @Autowired
    userService user_serv;


    @RequestMapping(value="/index",method=RequestMethod.POST)
    @ResponseBody
    public Integer pass(@RequestBody Map map){
        System.out.println(map);
        String username = (String)map.get("username");
        System.out.println(username);
        String password = (String)map.get("password");
        System.out.println(password);
        Integer x = user_serv.identity(username,password);
        System.out.println(x);

        return x;
    }

    @RequestMapping(value="/regist",method=RequestMethod.POST)
    @ResponseBody
    public Integer regist(@RequestBody Map map){
        System.out.println(map);
        String username = (String)map.get("username");
        System.out.println(username);
        String password = (String)map.get("password");
        System.out.println(password);
        String email = (String)map.get("email");
        System.out.println(email);
        Integer x = user_serv.regist(username,password,email);
        System.out.println(x);

        return x;
    }
}
