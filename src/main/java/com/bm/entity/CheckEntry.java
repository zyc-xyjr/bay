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

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "parent_id",insertable = false,updatable = false)
//    private CheckEntry checkEntry;

    @Column(name = "entry_name")
    private String entryName;

    @Column(name = "entry_key")
    private String entryKey;

    @Column(name = "normal_value")
    private String normalValue;

    @Column(name = "unit")
    private String unit;

    @Transient
    private List<CheckEntry> childrenEntries;

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

    public List<CheckEntry> getChildrenEntries() {
        return childrenEntries;
    }

    public void setChildrenEntries(List<CheckEntry> childrenEntries) {
        this.childrenEntries = childrenEntries;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    /*    public CheckEntry getCheckEntry() {
        return checkEntry;
    }

    public void setCheckEntry(CheckEntry checkEntry) {
        this.checkEntry = checkEntry;
    }*/
}
