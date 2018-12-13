package com.example.lihe.controller;

import com.example.lihe.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebInfosController {

    @RequestMapping(value = "/show-index")
    public String showIndex(Model model){

        Person single = new Person("wangbo",30);

        List<Person> persons = new ArrayList<Person>();

        Person p1 = new Person("lisi",49);
        Person p2 = new Person("zhangsan",89);
        Person p3 = new Person("wangwu",76);

        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(new Person("liwu",90));
        persons.add(new Person("lisi",90));
        persons.add(new Person("lisi",90));

        model.addAttribute("singelPerson",single);
        model.addAttribute("people",persons);

        return "index";
    }
}
