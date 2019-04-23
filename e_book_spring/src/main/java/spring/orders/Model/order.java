package spring.orders.Model;

public class order {
    private String order_id;
    private String username;
    private String time;
    private Integer status;
    private String ISBN;
    private Integer number;

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
