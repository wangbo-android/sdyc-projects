package com.springboot2.important.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot2.important.entity.People;
import com.springboot2.important.entity.Student;
import com.springboot2.important.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class JacksonController {

    @Autowired
    private ObjectMapper mapper;

    @RequestMapping(value = "/readtree.json",method = RequestMethod.GET)
    public @ResponseBody String readTree() throws IOException {

        String json = "{\"name\":\"lijz\",\"id\":10}";
        JsonNode node = mapper.readTree(json);
        String name = node.get("name").asText();
        int id = node.get("id").asInt();
        return "name:" + name + "id:" + id;
    }

    @RequestMapping(value = "/databind.json",method = RequestMethod.GET)
    public @ResponseBody String databind() throws IOException {

        String json = "{\"name\":\"lijz\",\"id\":10}";
        User user = mapper.readValue(json,User.class);

        return "name:" + user.getName() + "id:" + user.getId();
    }

    @RequestMapping(value = "/serialization.json",method = RequestMethod.GET)
    public @ResponseBody String custom() throws IOException {

        User user = new User();
        user.setId(23);
        user.setName("wangbo");

        String str  = mapper.writeValueAsString(user);

        return str;
    }

    @RequestMapping(value = "/jStu",method = RequestMethod.GET,
            produces = "application/json")
    public @ResponseBody Student jsonStu(){

        Student student = new Student();
        student.setId(1);
        student.setStuName("zhangssn");
        student.setDate(new Date());
        student.setAddress("石家庄市");
        student.setPassword("10101010101");

        return student;
    }

    @JsonView(People.IdView.class)
    @RequestMapping(value = "/jPe",method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody People jsonPeo(){

        People p = new People();

        p.setId(1);
        p.setName("wangbo");
        p.setInfos("jglkajrgjakl");
        p.setDesc("gerjgdngf");

        return p;
    }

    @RequestMapping(value = "/deserUser",method = RequestMethod.POST)
    public @ResponseBody String say(@RequestBody List<People> list){

        System.out.println(list.size());

        StringBuffer sb = new StringBuffer();

        for(People user : list){

            sb.append(user.getName()).append(" ");
        }

        return sb.toString();
    }
}
