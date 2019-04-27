package spring.orders.Service;

import spring.orders.Model.order;
import spring.orders.Dao.orderMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowCallbackHandler;

@Service
public class orderServiceImpl implements orderService{
    @Autowired
    private JdbcTemplate jdbc_tem;

    @Override
    public String signup_order(String username){return"";}

    @Override
    public ArrayList<order> getall_orders(String username){return new ArrayList<>();}
}
