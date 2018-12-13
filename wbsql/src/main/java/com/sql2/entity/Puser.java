package com.sql2.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="puser")
public class Puser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="department_id")
    private int departmentId;

    @Column(name="create_time")
    private Date createTime;

    public Puser(){}

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

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == null){

            return false;

        } else if(this == obj){

            return true;

        } else if(obj instanceof Puser){

            Puser puser = (Puser)obj;

            return puser.getName().equals(this.getName())
                    &&
                    puser.getCreateTime().equals(this.getCreateTime())
                    &&
                    puser.getDepartmentId()==this.getDepartmentId();
        } else{

            return false;
        }
    }

    @Override
    public int hashCode() {

        return this.getName().hashCode() * 32 + this.getDepartmentId() * 16 +
                this.getCreateTime().hashCode() * 64;
    }
}
