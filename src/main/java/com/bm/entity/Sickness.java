package com.bm.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 *可能患有的疾病类型
 */
@Entity
@Table(name = "tb_sickness")
public class Sickness extends IncrementEntity {

    @Column(name = "sick_name")
    private String sickName;

    @Column(name = "sick_code")
    private String sickCode;

    @Column(name = "percent")
    private String percent;

    @Transient
    private List<CheckEntryItem> checkEntryItemList;

    public String getSickName() {
        return sickName;
    }

    public void setSickName(String sickName) {
        this.sickName = sickName;
    }

    public String getSickCode() {
        return sickCode;
    }

    public void setSickCode(String sickCode) {
        this.sickCode = sickCode;
    }

    public List<CheckEntryItem> getCheckEntryItemList() {
        return checkEntryItemList;
    }

    public void setCheckEntryItemList(List<CheckEntryItem> checkEntryItemList) {
        this.checkEntryItemList = checkEntryItemList;
    }
}
