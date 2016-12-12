package com.bm.entity;

import javax.persistence.Column;

/**
 * Created by Administrator on 2016/12/11.
 */
public class HealthFormResult extends IncrementEntity {

    //异常情况
    @Column(name = "form_id")
    private Long healthFormId;

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

    public Long getHealthFormId() {
        return healthFormId;
    }

    public void setHealthFormId(Long healthFormId) {
        this.healthFormId = healthFormId;
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
