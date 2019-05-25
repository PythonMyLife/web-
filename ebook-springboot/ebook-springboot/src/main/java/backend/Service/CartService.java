package backend.Service;

import backend.Entity.Cart;

import java.util.List;

public interface CartService {
    //得到全部用户的购物车信息
    List<Cart> getAll();
    //得到username用户的购物车信息
    List<Cart> getAllUserCart(String username);

    Boolean saveCart(String username, String isbn, Integer num);
}
