package spring.books;

public class book {
    private String bookname;
    private String author;
    private String cover;
    private String ISBN;
    private Integer num;
    private Double price;

    public book(){

    }

    public book(String bookname,String author,String cover,String ISBN,Integer num,Double price){
        this.bookname = bookname;
        this.author = author;
        this.cover = cover;
        this.ISBN = ISBN;
        this.num = num;
        this.price = price;
    }

    public String getBookname(){
        return bookname;
    }

    public void setBookname(String bookname){
        this.bookname = bookname;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getCover(){
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getISBN(){
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getNum(){
        return num;
    }

    public void setNum(Integer num){
        this.num = num;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
