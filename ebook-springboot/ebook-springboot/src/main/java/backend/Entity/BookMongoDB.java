package backend.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Document(collection = "bookFeatures")
public class BookMongoDB {
    @Id
    private String id;
    private String isbn;
    private List<String> comments;

    public BookMongoDB(){}

    public BookMongoDB(String isbn, List<String> comments){
        this.isbn = isbn;
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        BookMongoDB that = (BookMongoDB) o;
        if(!Objects.equals(isbn, that.isbn)) return false;
        if(!Objects.equals(comments, that.comments)) return false;

        return true;
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public int hashCode(){
        int result = 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }
}
