package spring.carts.Service;
import spring.carts.Model.cart;
import spring.carts.Dao.cartMapper;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class cartServiceImpl implements cartService{
    @Autowired
    private JdbcTemplate jdbc_tem;


    /* 查询用户购物车的所有书 */
    @Override
    public ArrayList<cart> getall_carts(String username){
        String sql = "SELECT bookname,username,cover,price,carts.num as number,carts.ISBN FROM books join carts on books.ISBN=carts.ISBN where username=?";
        List<cart> carts = jdbc_tem.query(sql,new cartMapper(), username);
        return new ArrayList<>(carts);
    }

    /* 往购物车中更改书的数量 */
    @Override
    public void update_book(String username, String ISBN, Integer number){
        String sql_delete = "delete from carts where username=? and ISBN=?";
        String sql_add = "insert into carts(username,ISBN,num) values (?,?,?)";
        try{
            jdbc_tem.update(sql_delete,username,ISBN);
        }catch(Exception e){
        }
        try{
            jdbc_tem.update(sql_add,username,ISBN,number);
        }catch(Exception e){
        }
    }

    /* 从购物车中删除书 */
    @Override
    public void delete_book(String username, String ISBN){
        String sql_delete = "delete from carts where username=? and ISBN=?";
        try{
            jdbc_tem.update(sql_delete,username,ISBN);
        }catch(Exception e){
        }
    }

    @Override
    public void add_book(String username, String ISBN){
        String sql_search = "select bookname,username,cover,price,carts.num as number,carts.ISBN FROM books join carts on books.ISBN=carts.ISBN where username=? and carts.ISBN=?";
        String sql_delete = "delete from carts where username=? and ISBN=?";
        String sql_add = "insert into carts(username,ISBN,num) values (?,?,?)";
        int num;
        try{
            cart search = jdbc_tem.queryForObject(sql_search, new cartMapper(), username, ISBN);
            num = search.getNumber() + 1;
            jdbc_tem.update(sql_delete,username,ISBN);
        }catch(Exception e){
            num = 1;
        }
        try{
            jdbc_tem.update(sql_add,username,ISBN,num);
        }catch(Exception e){
        }
    }
}
