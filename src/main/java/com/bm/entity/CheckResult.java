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

    //异常情况
    @Column(name = "item_id")
    private Long itemId;
/*
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
    private String clinicDepartment;*/

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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
/*
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
    }*/
}

