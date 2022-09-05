package com.ldx.MyApplication.bean;

import java.util.List;

import lombok.Data;

@Data
public class HotNewsBeanResult {
    private String stat;
    private List<HotNewsBeanResultData> data;
    private String pageSize;
    private String page;

    public String getStat() {
        return stat;
    }

    public List<HotNewsBeanResultData> getData() {
        return data;
    }

    public String getPageSize() {
        return pageSize;
    }

    public String getPage() {
        return page;
    }
}
