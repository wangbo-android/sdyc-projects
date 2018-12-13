package com.example.lihe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {

    @RequestMapping(value = "/greeting")
    public String greeting(){

        return "hello world";
    }
}
