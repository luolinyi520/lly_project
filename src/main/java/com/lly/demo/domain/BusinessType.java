package com.lly.demo.domain;

public enum BusinessType {
    IMP(0, "进口"),
    EXP(1, "出口");

    private Integer code;
    private String value;

    BusinessType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String getValueByCode(Integer code) {
        BusinessType[] values = BusinessType.values();
        for (BusinessType value : values) {
            if (code == value.getCode()) {
                return value.getValue();
            }
        }
        return "";
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
//        BusinessType[] values = BusinessType.values();
//        for (BusinessType value : values) {
////            System.out.println(value.code+"---"+value.value);
//            System.out.println(value.getCode()+"---"+value.getValue());
//        }
        System.out.println(BusinessType.getValueByCode(3));
    }
}