package controller;

import entity.DemoObj;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DemoObjController {

    private static final Log logger = LogFactory.getLog(DemoObjController.class);

    @RequestMapping(value = "/obj",produces = "application/json,charset=UTF-8")
    public @ResponseBody DemoObj getJson(DemoObj demo, HttpServletRequest request){

        logger.info("*********");

        return new DemoObj(demo.getId(),demo.getName());
    }
}
