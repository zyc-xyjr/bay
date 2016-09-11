package com.bm.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
@Entity
@Table(name = "tb_check_entry_item")
public class CheckEntryItem extends IncrementEntity {

    @Column(name = "entry_id")
    private long entryId;

    @Transient
    private CheckEntry checkEntry;

    @Column(name = "item_label")
    private String itemLabel;

    @Column(name = "item_key")
    private String itemKey;

    @Column(name = "item_section")
    private String itemSection;

    @Transient
    private List<Sickness> sicknessList;

    public CheckEntry getCheckEntry() {
        return checkEntry;
    }

    public void setCheckEntry(CheckEntry checkEntry) {
        this.checkEntry = checkEntry;
    }

    public String getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(String itemLabel) {
        this.itemLabel = itemLabel;
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }

    public List<Sickness> getSicknessList() {
        return sicknessList;
    }

    public void setSicknessList(List<Sickness> sicknessList) {
        this.sicknessList = sicknessList;
    }

    public long getEntryId() {
        return entryId;
    }

    public void setEntryId(long entryId) {
        this.entryId = entryId;
    }

    public String getItemSection() {
        return itemSection;
    }

    public void setItemSection(String itemSection) {
        this.itemSection = itemSection;
    }
}
