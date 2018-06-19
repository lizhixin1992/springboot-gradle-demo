package com.example.demo.model;

import java.io.Serializable;

/**
 * @description:
 * @email:
 * @author: lizhixin
 * @createDate: 15:26 2018/6/19
 */
public class User implements Serializable{
    private String name;
    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
