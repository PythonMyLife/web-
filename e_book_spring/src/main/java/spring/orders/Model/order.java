package spring.orders.Model;

public class order {
    private String order_id; //订单号
    private String cover;    //封面
    private String bookname; //书名
    private String username; //用户名
    private String time;     //下单时间
    private Integer status;  //是否被删除
    private String ISBN;     //书籍ISBN号
    private Integer number;  //书籍数量
    private Double totalAmount; //总价(单本书为单价

    public order(){ ;}
    public order(String order_id, String bookname, String cover, String username,String time,Integer status,String ISBN,Integer number, Double totalAmount){
        this.username = username;
        this.bookname = bookname;
        this.cover = cover;
        this.order_id = order_id;
        this.time = time;
        this.status = status;
        this.ISBN = ISBN;
        this.number = number;
        this.totalAmount = totalAmount;
    }

    public String getOrder_id(){ return order_id; }
    public String getBookname(){ return bookname; }
    public String getCover(){ return cover; }
    public String getUsername(){ return username; }
    public String getTime(){ return time; }
    public String getISBN(){ return ISBN; }
    public Integer getStatus(){ return status; }
    public Integer getNumber(){ return number; }
    public Double getTotalAmount() { return totalAmount; }

    public void setOrder_id(String order_id){ this.order_id = order_id; }
    public void setBookname(String bookname){ this.bookname = bookname; }
    public void setCover(String cover){ this.cover = cover; }
    public void setUsername(String username){ this.username = username; }
    public void setTime(String time){ this.time = time; }
    public void setStatus(Integer status){ this.status = status; }
    public void setISBN(String ISBN){ this.ISBN = ISBN; }
    public void setNumber(Integer number){ this.number = number; }
    public void setTotalAmount(Double totalAmount){ this.totalAmount = totalAmount; }
}
