package com.sql2.controller;

import com.sql2.entity.ServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EnvironmentInfoController {

    @Autowired
    private Environment env;

    @Autowired
    private ServerConfig sc;

    @GetMapping(path = "/env-show")
    public @ResponseBody  String showEnvInfo(){

        return env.getProperty("server.port") + env.getProperty("user.dir") +
                env.getProperty("user.home") + env.getProperty("JAVA_HOME");

    }

    @GetMapping(path = "/value")
    public @ResponseBody String value(@Value("${server.port}") int port){

        return "port:" + port;
    }

    @GetMapping(path = "/getPro")
    public @ResponseBody String getApplicationProperties(){

        return sc.getPort() + sc.getServlet().getContextPath();
    }
}
