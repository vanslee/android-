package com.ldx.MyApplication.bean;

import java.util.List;

import lombok.Data;

@Data
public class NBANewBean {
    private String reason;
    private List<NBANewBeanItems> result;
}
