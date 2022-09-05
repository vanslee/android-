package com.ldx.MyApplication.bean;

import java.util.List;

import lombok.Data;

@Data
public class HistoryOnToday {
    private String reason;
    private List<HistoryOnTodayResult> result;
    private int error_code;

    @Override
    public String toString() {
        return "HistoryOnToday{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                '}';
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<HistoryOnTodayResult> getResult() {
        return result;
    }

    public void setResult(List<HistoryOnTodayResult> result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
