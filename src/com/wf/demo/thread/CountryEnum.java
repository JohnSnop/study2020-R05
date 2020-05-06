package com.wf.demo.thread;

/**
 * @author wf
 * @create 2020-05-06 21:50
 * @desc
 **/
public enum CountryEnum {
    ONE(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "燕"),
    FOUR(4, "赵"),
    FIVE(5, "魏"),
    SIX(6, "韩");

    int seq;
    String name;
    CountryEnum(int seq, String name){
        this.seq = seq;
        this.name = name;
    }
    public static CountryEnum getCountry(int index) {
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum value : values) {
            if (index == value.seq) {
                return value;
            }
        }
        return null;
    }
}
