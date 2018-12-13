package com.springboot2.important.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * Created by Administrator on 2018/7/7.
 */
public class User {

    public interface Update{}

    public interface Add{}

    @NotNull(groups = {Update.class})
    @Null(groups = {Add.class})
    private int id;

    private String name;

    private int age;

    private String infos;

    private String timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
