package com.springboot2.important.controller;

import com.springboot2.important.dao.PuserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DaoController {

    @Autowired
    private PuserDao puserDao;

    @RequestMapping(value = "/row-int",method = RequestMethod.GET)
    public String getRowResult(){

        return puserDao.getRowResult() + "";
    }
}
