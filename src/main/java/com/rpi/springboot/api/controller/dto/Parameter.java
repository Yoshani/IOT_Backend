package com.rpi.springboot.api.controller.dto;

public class Parameter {
    private String valueName;
    private String value;

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
