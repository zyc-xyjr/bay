package com.bm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


/**
 * Created by Administrator on 2016/10/15.
 */
@Entity
@Table(name = "tb_session")
public class SessionEntity extends IncrementEntity {

    @Column(name = "unique_id")
    private String uuid;

    @Column(name = "context")
    private String context;

    /**
     *  0 验证码 1 用户信息
     */
    @Column(name = "type")
    private int type;
    /**
     * 0无效 1有效
     */
    @Column(name = "status")
    private int status;

    @Column(name = "start_time")
    private Date startTime;

    public SessionEntity() {
    }

    public SessionEntity(String uuid, String context, int type,int status, Date startTime) {
        this.uuid = uuid;
        this.context = context;
        this.type = type;
        this.status = status;
        this.startTime = startTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
