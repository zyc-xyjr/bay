package com.baymax.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/9/5.
 */
@MappedSuperclass
public abstract class IncrementEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public IncrementEntity() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
