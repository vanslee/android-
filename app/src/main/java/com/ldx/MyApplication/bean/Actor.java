package com.ldx.MyApplication.bean;

import java.io.Serializable;

import lombok.Data;

/**
 * @TableName actor
 */

@Data
public class Actor implements Serializable {
    /**
     *
     */

    private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * 简介
     */
    private String description;

    /**
     * 头像
     */
    private String avatar;

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private static final long serialVersionUID = 1L;
}