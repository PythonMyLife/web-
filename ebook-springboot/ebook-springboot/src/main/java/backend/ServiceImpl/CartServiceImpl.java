package backend.ServiceImpl;

import backend.Dao.BookDao;
import backend.Dao.CartDao;
import backend.Dao.UserDao;
import backend.Entity.Book;
import backend.Entity.Cart;
import backend.Entity.User;
import backend.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;

    @Override
    public List<Cart> getAll(){
        return cartDao.getAll();
    }

    @Override
    public List<Cart> getAllUserCart(String username){
        return cartDao.getUserCart(username);
    }

    @Override
    public Boolean saveCart(String username, String isbn, Integer num){
        Cart cart = new Cart();
        Book book = bookDao.findByIsbn(isbn);
        User user = userDao.findByUsername(username);
        cart.setNum(num);
        cart.setBook(book);
        cart.setUser(user);
        cartDao.deleteCart(book, user);
        cartDao.saveCart(cart);
        return true;
    }
}
