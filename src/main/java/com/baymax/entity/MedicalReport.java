package com.baymax.entity;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/6.
 * 体检报告
 */
public class MedicalReport extends IncrementEntity {

    private String reportNo;

    private Date checkTime;

    private long userId;

    private String reportUrl;
}
