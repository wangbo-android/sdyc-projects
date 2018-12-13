package com.sql2.controller;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
public class UserController {

    private static final Log log = LogFactory.getLog(UserController.class);

    @GetMapping(path = "/user/{id}")
    public @ResponseBody  String getCredit(@PathVariable int id){

        log.info("id:" + id);

        return id + "";
    }

    @PostMapping(path = "/doc")
    public @ResponseBody String getFile(MultipartFile file) throws IOException{

        log.info(file.getOriginalFilename() + new String(file.getBytes()));

        return "upload success";
    }

    @GetMapping(path = "/user/{id}/{name}")
    public @ResponseBody String testParams(@PathVariable int id,
                                           @PathVariable String name,
                                           String message){

        log.info(name + id + message);

        return name + id + message;
    }

    @GetMapping(path = "/test/{id}/{name}")
    public @ResponseBody String testCheckBoxParam(@PathVariable int id,
                                                  @PathVariable String name,
                                                  Map<String,String> job){
        for(String key : job.keySet()){

            log.info(job.get(key));
        }
        return name + id;
    }

    @GetMapping(path = "/session")
    public @ResponseBody String sessionAttribute(HttpSession session){

        log.info(session.getAttribute("username"));

        return (String) session.getAttribute("username");
    }

    @GetMapping(path = "/cookie")
    public @ResponseBody String getCookie(Cookie cookie){

        log.info(cookie.getValue());

        return cookie.getValue();
    }

    @GetMapping(path = "/return")
    public String returnResults(Model model){

       model.addAttribute("number",10);

       return "test";
    }
}
