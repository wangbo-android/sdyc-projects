package com.sql2.controller;

import com.sql2.dao.PuserDao;
import com.sql2.entity.Puser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class DaoController {

    @Autowired
    private PuserDao puserDao;

    @GetMapping("/rowInt")
    public @ResponseBody  String jdbcDao(){

        return puserDao.getRowResult() + "";
    }

    @GetMapping("/getPuser")
    public @ResponseBody Puser getPuser(){

        return puserDao.getPuser(1);
    }

    @GetMapping("/getMap")
    public @ResponseBody Map getMapInfo(){

        return puserDao.getTableMapInfo(1);
    }

    @PostMapping("/insert")
    public @ResponseBody String insert(Puser puser){

        return String.valueOf(puserDao.insertPuser(puser));
    }
}
