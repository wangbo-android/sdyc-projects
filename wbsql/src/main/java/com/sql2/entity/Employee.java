package com.sql2.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eId;

    @Column(name = "e_name")
    private String eName;

    @Column(name="work_date")
    private Date workDate;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }
}
