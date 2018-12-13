package com.springboot2.important.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.beetl.ext.simulate.WebSimulate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WebSimulateController {

    private static final Log log = LogFactory.getLog(WebSimulateController.class);

    @Qualifier("websimulate")
    private WebSimulate webSimulate;

    @GetMapping(path = "/1.json")
    public void SimulateJson(HttpServletRequest request,
                                HttpServletResponse response){

        if(this.webSimulate == null){

            log.info("null");
            return;
        }

        webSimulate.execute(request,response);
    }
}
