package com.bm.enums;

/**
 * Created by Administrator on 2016/9/9.
 */
public enum PathogenType implements BaseEnum {
    PHYSIOLOGY("生理性"),
    PATHOLOGICAL("病理性");

    private final String key;

    PathogenType(String key) {
        this.key = key;
    }
    @Override
    public String getKey() {
        return key;
    }
}
