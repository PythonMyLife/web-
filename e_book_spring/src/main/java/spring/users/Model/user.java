package spring.users.Model;

public class user {
    private String username;
    private String password;
    private String email;
    private Integer status;
    private Integer identity;

    public user(){

    }

    public user(String username,String password,String email,Integer status,Integer identity){
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = status;
        this.identity = identity;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public  String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
