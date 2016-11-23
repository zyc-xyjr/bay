package com.bm.entity;

import com.bm.enums.BF;
import com.bm.enums.BMI;
import com.bm.enums.WHtR;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/9/6.
 * 体检单具体检查项检查结果
 */
@Entity
@Table(name = "tb_check_result")
public class CheckResult extends IncrementEntity {

    @Column(name = "health_form_id")
    private Long healthFormId;

    @Column(name = "entry_id")
    private Long entryId;

    //实际检查项数值
    @Column(name = "check_value")
    private Float checkValue;

    //偏高 偏低
    @Column(name = "result")
    private String result;

    public Long getHealthFormId() {
        return healthFormId;
    }

    public void setHealthFormId(Long healthFormId) {
        this.healthFormId = healthFormId;
    }

    public Long getEntryId() {
        return entryId;
    }

    public void setEntryId(Long entryId) {
        this.entryId = entryId;
    }

    public Float getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(Float checkValue) {
        this.checkValue = checkValue;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

