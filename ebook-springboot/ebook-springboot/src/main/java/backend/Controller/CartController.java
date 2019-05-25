package backend.Controller;


import backend.Entity.Cart;
import backend.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ebook")
public class CartController {
    @Autowired
    CartService cartService;

    @RequestMapping(value="/getcarts", method = RequestMethod.GET)
    @ResponseBody
    public List<Cart> getCarts(){
        return cartService.getAll();
    }

    @RequestMapping(value="/savecart", method = RequestMethod.GET)
    @ResponseBody
    public Boolean saveCart(String username, String isbn, Integer num){
        return cartService.saveCart(username, isbn, num);
    }

    @RequestMapping(value="/get_user_orders", method = RequestMethod.GET)
    @ResponseBody
    public List<Cart> getUserCarts(String username){
        List<Cart> cartList =  cartService.getAllUserCart(username);
        for(Cart cart:cartList){
            cart.getUser().setPassword("");
            cart.getUser().setStatus(0);
            cart.getUser().setIdentity(0);
        }
        return cartList;
    }
}
