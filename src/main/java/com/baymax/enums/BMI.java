package com.baymax.enums;

/**
 * Created by Administrator on 2016/9/6.
 */
public enum BMI implements BaseEnum {

   THIN("偏瘦",0f,18.5f,"脂肪肝患病率<20%","糖尿病患病率<10%"),
   MOD("适中",18.5f,24f,"脂肪肝患病率<20%","糖尿病患病率<10%"),
    OVERW("超重",25f,28f,"脂肪肝患病率30%左右","糖尿病患病率25%左右"),
    FIT("肥胖",28f,Float.MAX_VALUE,"脂肪肝患病率50%左右","糖尿病患病率55%左右");

    private final String key;//可视化描述
    private final float low;
    private final float high;
    private final String detOne;
    private final String detTwo;

    BMI(String key,float low,float high,String detOne,String detTwo){
        this.key=key;
        this.low=low;
        this.high=high;
        this.detOne=detOne;
        this.detTwo=detTwo;
    }

    @Override
    public String getKey() {
        return key;
    }

    public static BMI fromLowToHigh(float bmi) {
        for (BMI bm : BMI.values()) {
            if (bm.low<bmi&&bmi<=bm.high) {
                return bm;
            }
        }
        return null;
    }

}
