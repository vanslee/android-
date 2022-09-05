package com.ldx.MyApplication.bean;

public class PhoneBean {
    private String operator;
    private String area;

    @Override
    public String toString() {
        return "PhoneBean{" +
                "operator='" + operator + '\'' +
                ", area='" + area + '\'' +
                '}';
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
