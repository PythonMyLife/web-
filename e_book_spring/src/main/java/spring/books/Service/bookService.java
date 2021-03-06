package spring.books.Service;

import spring.books.Model.book;

import java.util.ArrayList;

public interface bookService {
    /* 新增一本书 */
    void insert(book book);

    /* 修改书籍的属性 */
    void change(book book);

    /* 删除一本书（提供主键ISBN） */
    void delete(String ISBN);

    /* 查找一本书（提供主键ISBN） */
    book search(String ISBN);

    /* 得到全部的书籍列表 */
    ArrayList<book> getall_books();

    /* 书籍详情 */
    String detail(String ISBN);
}
