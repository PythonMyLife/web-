package spring.orders.Service;

import spring.orders.Model.order;

import java.util.ArrayList;

public interface orderService {
    /* 提交订单 */
    String signup_order(String username);

    /* 查看单个用户的所有订单 */
    ArrayList<order> getall_orders(String username);

    /* 查看所有用户的所有订单 */
    ArrayList<order> getOrders();
}
