package com.demo.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tb_loan")
public class Loan extends UUIDEntity {


    @Column(name = "title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
