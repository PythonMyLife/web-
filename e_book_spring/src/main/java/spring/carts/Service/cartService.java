package spring.carts.Service;

import spring.carts.Model.cart;
import java.util.ArrayList;

public interface cartService {
    /* 查询用户购物车的所有书 */
    ArrayList<cart> getall_carts(String username);

    /* 往购物车中更改书的数量 */
    void update_book(String username, String ISBN, Integer number);

    /* 从购物车中删除书 */
    void delete_book(String username, String ISBN);

    /*加购（有则加一，无则增加）*/
    void add_book(String username, String ISBN);

}
