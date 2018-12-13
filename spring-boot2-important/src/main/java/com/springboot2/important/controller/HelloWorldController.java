package com.springboot2.important.controller;

import com.springboot2.important.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;

@Controller
public class HelloWorldController {

    private static final Log log = LogFactory.getLog(HelloWorldController.class);

    @RequestMapping(value = "/json")
    public @ResponseBody String say(){

        return "hello world";
    }

    @RequestMapping(value = "/list.json",method = RequestMethod.GET)
    public @ResponseBody List<String> allString(){

        List<String> strs = new ArrayList<String>();

        strs.add("hello world");
        strs.add("good time");
        strs.add("new day");

        return strs;
    }

    @RequestMapping(value = "/user.json",method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody User userJson(){

        return new User();
    }

    @RequestMapping(value = "/str/{id}.json",method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody String getId(@PathVariable("id") Long id){

        return id + "";
    }

    @RequestMapping(value = "/head.json",method = RequestMethod.HEAD)
    public @ResponseBody String getHead(){

        return "good";
    }

    @RequestMapping(value = "/user-json.json",method = RequestMethod.GET ,consumes = "application/json",produces = "application/json")
    public @ResponseBody User forJson(){

        return new User();
    }

    @RequestMapping(value = "/update.json",method = RequestMethod.POST)
    public @ResponseBody User updateUser(User user){

        return user;
    }

    @PostMapping(path = "/savaUser.json")
    public @ResponseBody String savaUserByJson(@RequestBody User user){

        return user.getName();
    }

    @PostMapping(path = "/upload")
    public @ResponseBody String handleFormUpload(String name, MultipartFile file) throws IOException {

        if(!file.isEmpty()){

            String fileName = file.getOriginalFilename();

            File toFile = new File("E:" + File.separator + fileName);

            file.transferTo(toFile);

            return name;

        }else{

            return "fail";
        }
    }

    @GetMapping(path = "/date")
    public @ResponseBody String printDate(Date date){

        log.info(date);

        return "date";
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public @ResponseBody String addWorkInfo(@Validated({User.Update.class}) User user, BindingResult result){

        if (result.hasErrors()){

            List<ObjectError> list = result.getAllErrors();

            FieldError fe = (FieldError) list.get(0);

            log.info(fe.getObjectName() + "," + fe.getField() + "," + fe.getDefaultMessage());

            return "has error:" + fe.getObjectName() + "," + fe.getField() + "," + fe.getDefaultMessage();
        }

        return user.getId() + "";
    }

    @PostMapping(path = "/admin/login")
    public @ResponseBody String login(User user, HttpSession session){

        log.info(user.getInfos() + user.getName());

        session.setAttribute("user",user);

        return "success";
    }

    @RequestMapping(value = "/now.json",method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody Map now(){

        Map<String,Date> map = new HashMap<String,Date>();
        map.put("time",new Date());
        return map;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder){

        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }
}
