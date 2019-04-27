package spring.carts.Model;

public class cart {
    private String bookname;
    private String username;
    private Double price;
    private Integer number;
    private String cover;
    private String ISBN;

    public cart(){

    }

    public cart(String bookname, String username, String cover, Double price, Integer number, String ISBN){
        this.bookname = bookname;
        this.username = username;
        this.cover = cover;
        this.price = price;
        this.number = number;
        this.ISBN = ISBN;
    }

    public String getBookname(){ return bookname; }
    public String getUsername(){ return username; }
    public String getCover(){ return cover; }
    public Double getPrice(){ return price; }
    public Integer getNumber(){ return number; }
    public String getISBN(){ return ISBN; }

    public void setBookname(String bookname){ this.bookname = bookname; }
    public void setUsername(String username){ this.username = username; }
    public void setCover(String cover){ this.cover = cover; }
    public void setNumber(Integer number) { this.number = number; }
    public void setPrice(Double price) { this.price = price; }
    public void setISBN(String ISBN){ this.ISBN = ISBN; }
}
