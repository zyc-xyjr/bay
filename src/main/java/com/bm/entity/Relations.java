package com.bm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/12/15.
 */
@Entity
@Table(name = "tb_relation")
public class Relations extends IncrementEntity {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "cilent_id")
    private String cilentId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCilentId() {
        return cilentId;
    }

    public void setCilentId(String cilentId) {
        this.cilentId = cilentId;
    }
}
