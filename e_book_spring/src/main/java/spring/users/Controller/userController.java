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
    /*@ResponseBody
    public Integer login(String username, String password) throws Exception {
        System.out.println(username);
        return user_serv.identity(username,password);
    }*/
    /*public String pass(@RequestBody Map map){
        System.out.println(map);
        String username = (String)map.get("username");
        System.out.println(username);
        String data = "success";
        return data;
    }*/
    @ResponseBody
    public String pass(){
        return "success";
    }

}
