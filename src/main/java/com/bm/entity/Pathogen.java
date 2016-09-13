package com.bm.entity;

import com.bm.enums.PathogenType;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/9/9.
 * 引起这些检查结果的可能性原因
 */
@Entity
@Table(name = "tb_pathogen")
public class Pathogen extends IncrementEntity {

    @Column(name = "pathogen_type")
    @Enumerated(EnumType.STRING)
    private PathogenType pathogenType;

    @Column(name = "cause_name")
    private String causeName;

    public PathogenType getPathogenType() {
        return pathogenType;
    }

    public void setPathogenType(PathogenType pathogenType) {
        this.pathogenType = pathogenType;
    }

    public String getCauseName() {
        return causeName;
    }

    public void setCauseName(String causeName) {
        this.causeName = causeName;
    }
}
