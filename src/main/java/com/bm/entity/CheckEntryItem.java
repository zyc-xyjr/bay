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

    @Column(name = "small_value")
    private float smallValue;

    @Column(name = "big_value")
    private float bigValue;

    @Column(name = "analysis")
    private String analysis;

    @Column(name = "medical_advice")
    private String medicalAdvice;

    @Column(name = "life_guidance")
    private String lifeGuidance;

    @Column(name = "clinic_department")
    private String clinicDepartment;

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

    public float getSmallValue() {
        return smallValue;
    }

    public void setSmallValue(float smallValue) {
        this.smallValue = smallValue;
    }

    public float getBigValue() {
        return bigValue;
    }

    public void setBigValue(float bigValue) {
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
