package backend.ServiceImpl;

import backend.Dao.OrderDao;
import backend.Dao.OrderItemDao;
import backend.Entity.Order;
import backend.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderItemDao orderItemDao;

    @Override
    public List<Order> findAllOrder(){
        return orderDao.findAll();
    }

    @Override
    public List<Order> findAllOrderByUsernameAndStatus(String username){
        return orderDao.findAllByUserAndStatus(username, 0);
    }
}
