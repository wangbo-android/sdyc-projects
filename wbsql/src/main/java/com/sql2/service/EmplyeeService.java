package com.sql2.service;

import com.sql2.entity.Employee;
import com.sql2.entity.Puser;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmplyeeService {

    public Employee findUser(int id);

    public String saveEmp(Puser puser);

    public List<Puser> findAll();

    public List<Puser> findAllOnePage();

    public Puser findPuser(String name,Integer departmentId);

    public List<Puser> queryPusersPageOne(Integer departmentId);
}
