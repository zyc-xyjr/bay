package com.bm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/9/6.
 */
@Entity
@Table(name = "tb_user")
public class User extends IncrementEntity {


    @Column(name = "nick_name")
    private String nickName;//用户昵称

    @Column(name = "name")
    private String name;//用户姓名

    @Column(name = "user_name")
    private String userName;//用户名

    @Column(name = "password")
    private String password;//密码

    @Column(name = "email")
    private String email;//邮箱

    @Column(name = "height")
    private float height;//身高

    @Column(name = "weight")
    private float weight;//体重

    @Column(name = "waistline")
    private float waistline;//腰围

    @Column(name = "age")
    private Integer age;//年龄

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWaistline() {
        return waistline;
    }

    public void setWaistline(float waistline) {
        this.waistline = waistline;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
