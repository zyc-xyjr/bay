package com.bm.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/12/15.
 */
@Entity
@Table(name = "tb_push_message")
public class AppPushMessage extends IncrementEntity {

    private String title;

    private String content;

    private Integer status;

    private Integer type;

    private String url;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "{\"id\":\""+super.getId()+"\",\"tt\":\""+this.title+"\",\"tp\":"+this.type+",\"url\":\""+this.url+"\",\"cs\":\""+this.content+"\"}";
    }
}
