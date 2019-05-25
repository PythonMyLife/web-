package backend.Repository;


import backend.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
    Book findByIsbn(String isbn);
    void deleteByIsbn(String isbn);
}