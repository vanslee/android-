package com.ldx.MyApplication.bean;

import java.util.List;

import lombok.Data;

@Data
public class NBANewBeanItem {
    private String date;
    private String week;
    private List<NBANewBeanItemList> list;
}
