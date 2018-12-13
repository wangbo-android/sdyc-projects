package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.CustomerService;

import javax.servlet.http.HttpSession;

@Controller
public class CustomerController {

    private static final Log logger = LogFactory.getLog(CustomerController.class);

    @Autowired
    private CustomerService cs;

    @RequestMapping(value = "/showCu")
    public String showCustomer(HttpSession session, Model model){

        logger.info("show customer page");

        model.addAttribute("info",cs.getInfos("wangbo"));

        session.setAttribute("info","This is session's infos");

        return "customer";
    }

}
