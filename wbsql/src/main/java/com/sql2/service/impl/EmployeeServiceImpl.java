package com.sql2.service.impl;

import com.sql2.dao.EmployeeRepository;
import com.sql2.entity.Company;
import com.sql2.entity.Employee;
import com.sql2.entity.Puser;
import com.sql2.service.EmplyeeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmplyeeService{

    private static final Log log = LogFactory.getLog(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EntityManager em;

    @Override
    public Employee findUser(int id) {

        return null;
    }

    @Override
    public String saveEmp(Puser puser) {

        Puser p = employeeRepository.save(puser);

        return p.getName();
    }

    @Override
    public List<Puser> findAll() {

        Sort sort = new Sort("id");

        List<Puser> pusers = employeeRepository.findAll(sort);

        return pusers;
    }

    @Override
    public List<Puser> findAllOnePage() {

        PageRequest pageRequest = PageRequest.of(0,4);

        Page<Puser> pagePuser =  employeeRepository.findAll(pageRequest);

        long totalPage = pagePuser.getTotalPages();

        long count = pagePuser.getTotalElements();

        log.info("totalPage:" + totalPage + "count:" + count);

        return pagePuser.getContent();
    }

    @Override
    public Puser findPuser(String name, Integer departmentId) {

        Puser puser = employeeRepository.findPuser(name,departmentId);

        return puser;
    }

    @Override
    public List<Puser> queryPusersPageOne(Integer departmentId) {

        PageRequest pageRequest = PageRequest.of(0,4);

        Page<Puser> page = employeeRepository.queryPusersPageOne(departmentId,pageRequest);

        return page.getContent();
    }
}
