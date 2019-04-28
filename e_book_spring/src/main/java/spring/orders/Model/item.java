package spring.orders.Model;

public class item {
    private String cover;
    private String title;
    private Integer number;
    private Double price;

    public item(){}
    public item(String cover, String title, Integer number, Double price){
        this.cover = cover;
        this.title = title;
        this.number = number;
        this.price = price;
    }

    public String getCover(){ return cover; }
    public String getTitle(){ return title; }
    public Integer getNumber(){ return number; }
    public Double getPrice(){ return price; }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
