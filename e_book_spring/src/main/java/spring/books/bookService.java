package spring.books;

import spring.books.book;

public interface bookService {
    /* 新增一本书 */
    void insert(book book);

    /* 删除一本书（提供主键ISBN） */
    void delete(String ISBN);

    /* 查找一本书（提供主键ISBN） */
    book search(String ISBN);

}