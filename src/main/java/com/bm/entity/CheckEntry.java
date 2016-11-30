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
    private Long parentId = 0l;

    @Column(name = "entry_name")
    private String entryName;

    @Column(name = "entry_key")
    private String entryKey;

    @Column(name = "normal_min_value")
    private Float normalMinValue;

    @Column(name = "normal_max_value")
    private Float normalMaxValue;

    @Column(name = "normal_value")
    private String normalValue;

    @Column(name = "unit")
    private String unit;


    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
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


    public String getNormalValue() {
        return normalValue;
    }

    public void setNormalValue(String normalValue) {
        this.normalValue = normalValue;
    }

    public Float getNormalMinValue() {
        return normalMinValue;
    }

    public void setNormalMinValue(Float normalMinValue) {
        this.normalMinValue = normalMinValue;
    }

    public Float getNormalMaxValue() {
        return normalMaxValue;
    }

    public void setNormalMaxValue(Float normalMaxValue) {
        this.normalMaxValue = normalMaxValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
