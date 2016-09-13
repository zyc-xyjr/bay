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

    @Column(name = "item_id")
    private long itemId;

    @Column(name = "pathogen_id")
    private long pathogenId;

    @Column(name = "percent")
    private float percent;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getPathogenId() {
        return pathogenId;
    }

    public void setPathogenId(long pathogenId) {
        this.pathogenId = pathogenId;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
}
