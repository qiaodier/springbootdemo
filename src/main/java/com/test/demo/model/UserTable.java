package com.test.demo.model;
import javax.persistence.*;
import java.io.Serializable;

@Table(name = "user_table")
public class UserTable implements Serializable {

    @Id
    @Column
    private Integer userId;
    @Column
    private String userName;
    @Column
    private String userPass;
    @Column
    private String userPhone;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
