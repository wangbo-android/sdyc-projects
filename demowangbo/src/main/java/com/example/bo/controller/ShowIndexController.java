package com.example.bo.controller;

import com.example.bo.entity.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowIndexController {

    @Autowired
    private AuthorSettings as;

    @RequestMapping(value = "/index")
    public String showIndex(){

        return as.getName() + as.getAge();
    }
}
