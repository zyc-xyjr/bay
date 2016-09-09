package com.baymax.entity;

import com.baymax.enums.BF;
import com.baymax.enums.BMI;
import com.baymax.enums.WHtR;

/**
 * Created by Administrator on 2016/9/6.
 * 检查结果
 */
public class CheckResult extends IncrementEntity {

    private long reportId;

    private BMI bmi;

    private BF bf;

    private WHtR whtr;
}
