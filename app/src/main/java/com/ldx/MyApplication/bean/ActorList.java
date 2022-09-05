package com.ldx.MyApplication.bean;

import java.util.List;

public class ActorList {
    List<Actor> data;

    public List<Actor> getData() {
        return data;
    }

    public void setData(List<Actor> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ActorList{" +
                "data=" + data +
                '}';
    }
}
