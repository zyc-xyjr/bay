package com.demo.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tb_loan")
public class Loan extends UUIDEntity {


    @Column(name = "title")
    private String title;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "loan")
    private List<Invest> invests;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
