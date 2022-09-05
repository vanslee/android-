package com.ldx.MyApplication.bean;

import java.util.List;

import lombok.Data;

@Data
public class NBANewBeanItems {
    private String title;
    private String duration;
    private List<NBANewBeanItem> matchs;
}
