package backend.Dao;

import backend.Entity.BookMongoDB;

import java.util.List;

public interface BookMongoDBDao {
    //得到书评
    BookMongoDB findByIsbn(String isbn);

    //增加书评
    void save(BookMongoDB bookMongoDB);
}
