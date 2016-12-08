package com.bm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/18.
 */
@Entity
@Table(name = "tb_health_form")
public class HealthForm extends IncrementEntity {

    @Column(name = "userId")
    private Long userId;

    @Column(name = "form_name")
    private String formName;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_path")
    private String filePath;

    private String viewPath;

    @Column(name = "upload_time")
    private Date uploadTime;

    //init未处理 processing处理中 complete已处理
    @Column(name = "status")
    private String status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getViewPath() {
        return "/healForm/picture/"+getId();
    }

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}
