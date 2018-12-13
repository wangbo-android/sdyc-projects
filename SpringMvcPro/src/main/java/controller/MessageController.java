package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {

    @RequestMapping(value = "/showMesaage")
    public String showMessagePage(){

        return "message";
    }
}
