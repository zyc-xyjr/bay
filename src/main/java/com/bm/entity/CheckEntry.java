package com.bm.entity;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "entry_key")
    private String entryKey;

    @Column(name = "normal_value")
    private String normalValue;

    @Transient
    private List<CheckEntryItem> checkEntryItemList;

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

    public String getEntryKey() {
        return entryKey;
    }

    public void setEntryKey(String entryKey) {
        this.entryKey = entryKey;
    }

    public List<CheckEntryItem> getCheckEntryItemList() {
        return checkEntryItemList;
    }

    public void setCheckEntryItemList(List<CheckEntryItem> checkEntryItemList) {
        this.checkEntryItemList = checkEntryItemList;
    }

    public String getNormalValue() {
        return normalValue;
    }

    public void setNormalValue(String normalValue) {
        this.normalValue = normalValue;
    }
}
