package com.boshuo.util.enums;

public enum LevelEnums {


    benke(60,"本科"),
    suoshi(70,"硕士"),
    boshi(80,"博士");

    private Integer type;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    LevelEnums(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    public static Integer getTypes(String value){
        LevelEnums[] enums = values();
        for(LevelEnums enums1 : enums){
            if (enums1.getValue().equals(value)){
                return enums1.getType();
            }
        }
        return null;
    }
}
