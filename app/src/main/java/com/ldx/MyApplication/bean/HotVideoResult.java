package com.ldx.MyApplication.bean;

import java.util.List;


public class HotVideoResult {
    private String reason;
    private List<HotVideoInfo> result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<HotVideoInfo> getResult() {
        return result;
    }

    public void setResult(List<HotVideoInfo> result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
