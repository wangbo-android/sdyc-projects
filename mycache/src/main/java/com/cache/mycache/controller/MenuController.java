package com.cache.mycache.controller;

import com.cache.mycache.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MenuController {

    @Autowired
    private MenuService ms;

    @GetMapping(path = "/menu/{id}")
    public @ResponseBody String getMenuString(@PathVariable Long id){

       return String.valueOf(ms.getMenu(id));
    }
}
