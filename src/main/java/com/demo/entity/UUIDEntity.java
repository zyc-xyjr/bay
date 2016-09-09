package com.demo.entity;

import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Administrator on 2016/9/5.
 */
@MappedSuperclass
public abstract class UUIDEntity extends BaseEntity{

  /*  @UuidGenerator(
            name = "UUID_GEN"
    )*/
    @Id
 /*   @GeneratedValue(
            generator = "UUID_GEN"
    )*/
    @Column(
            name = "ID",
            length = 36
    )
    private String id;

    public UUIDEntity() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
