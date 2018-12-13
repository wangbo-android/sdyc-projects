package com.springboot2.important.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springboot2.important.config.JsonCustomDeserialize;
import com.springboot2.important.config.JsonCustomSerialize;

@JsonSerialize(using = JsonCustomSerialize.class)
//@JsonDeserialize(using = JsonCustomDeserialize.class)
public class People {

    public interface IdView {}

    public interface IdViewName extends IdView {}

    @JsonView(IdView.class)
    private int id;

    @JsonView(IdViewName.class)
    private String name;

    private String address;

    private String infos;

    private String desc;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
