package com.baymax.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/9/6.
 * 检查项实体
 */
@Entity
@Table(name = "tb_check_entry")
public class CheckEntry extends IncrementEntity {

    @Column(name = "parent_id")
    private long parentId;

    @Column(name = "entry_name")
    private String entryName;

    @Column(name = "entry_value")
    private String entryValue;

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getEntryValue() {
        return entryValue;
    }

    public void setEntryValue(String entryValue) {
        this.entryValue = entryValue;
    }
}
