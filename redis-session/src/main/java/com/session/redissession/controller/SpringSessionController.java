package com.session.redissession.controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SpringSessionController {

    private Log log = LogFactory.getLog(SpringSessionController.class);

    @GetMapping(path = "/putSession")
    public @ResponseBody String putSession(HttpServletRequest request){

        HttpSession session = request.getSession();

        log.info(session.getClass());
        log.info(session.getId());

        String name = "wangbo";
        session.setAttribute("user",name);

        return "hey,"+ name;
    }
}
