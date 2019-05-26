package backend.Service;

import backend.Entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrder();
    List<Order> findAllOrderByUsernameAndStatus(String username);
}
