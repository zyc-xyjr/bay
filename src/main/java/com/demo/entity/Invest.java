package com.demo.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tb_invest")
public class Invest extends UUIDEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "loanid")
    private Loan loan;
}
