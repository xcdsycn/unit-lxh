package com.lxh.unit.custommatcher;
/**
 * Created by lxh on 2018/1/21.
 */

/**
 * 当username和password都为“admin”时表示是管理员（Admin User）
 * 创建一个自己的Matcher并运用到assertThat语法中去。
 * @author lxh
 * @Date 2018/1/21
 */
public class User {
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
