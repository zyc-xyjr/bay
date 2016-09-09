package com.bm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/9/9.
 * 检查值和病因中间实体
 */
@Entity
@Table(name = "tb_entry_item_pathogen")
public class EntryItemPathogen extends IncrementEntity {

    @Column(name = "entry_id")
    private long entryId;

    @Column(name = "pathogen_id")
    private long pathogenId;

    public long getEntryId() {
        return entryId;
    }

    public void setEntryId(long entryId) {
        this.entryId = entryId;
    }

    public long getPathogenId() {
        return pathogenId;
    }

    public void setPathogenId(long pathogenId) {
        this.pathogenId = pathogenId;
    }
}
