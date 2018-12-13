package com.springboot2.important.controller;

import com.springboot2.important.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BeetlController {

    @GetMapping(path = "/hello.btl")
    public String indexBeetl(Model model){

        User user = new User();
        user.setName("wangbo");
        user.setAge(20);
        model.addAttribute("user",user);

        return "/beetl/hello.btl";
    }

    @RequestMapping(value = "/be.btl")
    public String beetlExpress(Model model){

        List<User> userList = new ArrayList<>();

        User user1 = new User();
        user1.setAge(34);
        user1.setName("wangbo");

        User user2 = new User();
        user2.setName("lisi");
        user2.setAge(30);

        userList.add(user1);
        userList.add(user2);

        model.addAttribute("user",user1);
        model.addAttribute("userList",userList);

        return "/beetl/beetl-express.btl";
    }

    @GetMapping(path = "/layout")
    public String layoutTabFunc(){

        return "/beetl/layout.btl";
    }
}
