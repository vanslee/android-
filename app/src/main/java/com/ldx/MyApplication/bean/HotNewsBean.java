package com.ldx.MyApplication.bean;

import java.util.List;

import lombok.Data;


public class HotNewsBean {
    private String reason;
    private List<HotNewsBeanResult> result;
    private int error_code;

    public List<HotNewsBeanResult> getResult() {
        return result;
    }
}
