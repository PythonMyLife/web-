package spring.orders.Service;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import spring.books.Dao.bookMapper;
import spring.books.Model.book;
import spring.carts.Dao.cartMapper;
import spring.carts.Model.cart;
import spring.orders.Dao.orderMapper;
import spring.orders.Model.order;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class orderServiceImpl implements orderService{
    @Autowired
    private JdbcTemplate jdbc_tem;

    private static Integer order_id = 0;

    private String get_time(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());  // new Date()为获取当前系统时间
    }

    @Override
    public String signup_order(String username){
        try {
            List<cart> search = jdbc_tem.query("select username,carts.ISBN,carts.num as number,bookname,cover,price from carts join books on carts.ISBN=books.ISBN where username = ?", new cartMapper(), username);
            LinkedList<cart> cartList = new LinkedList<>(search);
            //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            //String dateTime = df.format(new Date()); // Formats a Date into a date/time string.
            //System.out.println(dateTime);
            String dateTime = get_time();
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbc_tem.update(new PreparedStatementCreator() {
                public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                    // 获取PreparedStatement，并指定返回自增key
                    PreparedStatement ps = con.prepareStatement("insert into orders(username, time) values(?, ?)", Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, username);
                    ps.setString(2, dateTime);
                    return ps;
                }
            }, keyHolder);
            Number order_id = keyHolder.getKey();

            for (cart cart : cartList) {
                String isbn = cart.getISBN();
                Integer newnum = cart.getNumber();
                try {
                    book old = jdbc_tem.queryForObject("select * from books where ISBN = ?", new bookMapper(), isbn);
                    if (old.getNum() < newnum) {
                        jdbc_tem.update("delete from orders where order_id = ?", order_id);
                        return old.getBookname() + "库存不足";
                    }
                    jdbc_tem.update("insert into orderitems(order_id, ISBN, number) values(?, ?, ?)", order_id, isbn, newnum);
                    jdbc_tem.update("update books set num = ? where ISBN = ?", old.getNum() - newnum, isbn);
                }catch (Exception e) {

                }
            }
            jdbc_tem.update("delete from carts where username = ?", username);
            return "成功";
        }catch (Exception e) {
            return "失败";
        }
    }

    @Override
    public ArrayList<order> getall_orders(String username){
        String sql_get = "select orders.order_id,cover,bookname,username,time,status,books.ISBN,orderitems.number as number,books.price as totalAmount from orders natural join orderitems join books on orderitems.ISBN=books.ISBN where orders.username=? order by order_id";
        try{
            List<order> order_list = jdbc_tem.query(sql_get,new orderMapper(),username);
            return new ArrayList<>(order_list);
        }catch (Exception e){
            System.out.println("失败");
        }
        return new ArrayList<>();
    }
}
