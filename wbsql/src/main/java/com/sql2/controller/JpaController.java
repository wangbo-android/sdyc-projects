package com.sql2.controller;

import com.sql2.entity.Puser;
import com.sql2.service.EmplyeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JpaController {

    @Autowired
    private EmplyeeService es;

    @PostMapping(path="/savePuser")
    public @ResponseBody  String saveEmloyee(Puser puser){


        return es.saveEmp(puser);
    }

    @GetMapping(path = "/findAll")
    public @ResponseBody List<Puser> findAll(){

        return es.findAll();
    }

    @GetMapping(path = "/page")
    public @ResponseBody List<Puser> findAllOnePage(){

        return es.findAllOnePage();
    }

    @GetMapping(path = "/find-puser")
    public @ResponseBody Puser findPuser(){

        return es.findPuser("王博",1001);
    }

    @GetMapping(path = "/query")
    public @ResponseBody List<Puser> queryNativeQueryPuser(){

        return es.queryPusersPageOne(1001);
    }
}
