package com.ldx.MyApplication.bean;

import lombok.Data;

@Data
public class HistoryOnTodayResult {
    private String day;
    private String date;
    private String title;
    private String e_id;

    @Override
    public String toString() {
        return "HistoryOnTodayResult{" +
                "day='" + day + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", e_id='" + e_id + '\'' +
                '}';
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }
}
