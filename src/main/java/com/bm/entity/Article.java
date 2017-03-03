package com.bm.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/1/17.
 */
@Entity
@Table(name = "tb_article")
public class Article extends IncrementEntity {

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "TEXT",name = "json_data")
    private String jsonData;

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
