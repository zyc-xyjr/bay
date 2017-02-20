package com.bm.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 * 检查项对应的异常情况
 */

@Entity
@Table(name = "tb_check_entry_item")
public class CheckEntryItem extends IncrementEntity {

    @Column(name = "entry_id")
    private long entryId;

    @Column(name = "item_label")
    private String itemLabel;

    @Column(name = "small_value")
    private Float smallValue;

    @Column(name = "big_value")
    private Float bigValue;

    //异常解析
    @Column(name = "analysis")
    private String analysis;

    //医学建议
    @Column(name = "medical_advice")
    private String medicalAdvice;

    //生活指导
    @Column(name = "life_guidance")
    private String lifeGuidance;

    @Column(name = "clinic_department")
    private String clinicDepartment;



    public String getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(String itemLabel) {
        this.itemLabel = itemLabel;
    }


    public long getEntryId() {
        return entryId;
    }

    public void setEntryId(long entryId) {
        this.entryId = entryId;
    }

    public Float getSmallValue() {
        return smallValue;
    }

    public void setSmallValue(Float smallValue) {
        this.smallValue = smallValue;
    }

    public Float getBigValue() {
        return bigValue;
    }

    public void setBigValue(Float bigValue) {
        this.bigValue = bigValue;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getMedicalAdvice() {
        return medicalAdvice;
    }

    public void setMedicalAdvice(String medicalAdvice) {
        this.medicalAdvice = medicalAdvice;
    }

    public String getLifeGuidance() {
        return lifeGuidance;
    }

    public void setLifeGuidance(String lifeGuidance) {
        this.lifeGuidance = lifeGuidance;
    }

    public String getClinicDepartment() {
        return clinicDepartment;
    }

    public void setClinicDepartment(String clinicDepartment) {
        this.clinicDepartment = clinicDepartment;
    }
}
