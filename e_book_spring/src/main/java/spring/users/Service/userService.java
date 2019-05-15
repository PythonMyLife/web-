package spring.users.Service;

import spring.users.Model.user;

import java.util.ArrayList;

public interface userService {
    /**
     *  查询全部user
     */
    ArrayList<user> getUsers();

    /**
     *  更改一个user的status
     */
    void changeStatus(String username);

    /**
     * 查询username 和 password信息是否合法，返回idendity（-1为不合法，0为用户，1为管理员，2为被禁用）
     */
    Integer identity(String username, String password);

    /**
     * 用户注册（返回1表示注册成功，0表示注册失败（用户名重复））
     */
    Integer regist(String username, String password, String email);
}
