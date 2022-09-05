package com.ldx.MyApplication.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String phone;
    private String password;

    public User(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
