package spring.orders.Model;

public class order {
    private String order_id; //订单号
    private String username; //用户名
    private String time;     //下单时间
    private Integer status;  //是否被删除
    private String ISBN;     //书籍ISBN号
    private Integer number;  //书籍数量

    public order(){ ;}
    public order(String order_id,String username,String time,Integer status,String ISBN,Integer number){
        this.username = username;
        this.order_id = order_id;
        this.time = time;
        this.status = status;
        this.ISBN = ISBN;
        this.number = number;
    }

    public String getOrder_id(){ return order_id; }
    public String getUsername(){ return username; }
    public String getTime(){ return time; }
    public String getISBN(){ return ISBN; }
    public Integer getStatus(){ return status; }
    public Integer getNumber(){ return number; }

    public void setOrder_id(String order_id){ this.order_id = order_id; }
    public void setUsername(String username){ this.username = username; }
    public void setTime(String time){ this.time = time; }
    public void setStatus(Integer status){ this.status = status; }
    public void setISBN(String ISBN){ this.ISBN = ISBN; }
    public void setNumber(Integer number){ this.number = number; }
}
