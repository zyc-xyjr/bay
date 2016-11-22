package com.bm.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/9/5.
 */
@MappedSuperclass
public abstract class IncrementEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public IncrementEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
