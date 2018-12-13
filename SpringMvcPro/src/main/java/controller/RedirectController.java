package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {

    private static final Log logger = LogFactory.getLog(RedirectController.class);

    @RequestMapping(value = "/showGoto",method = RequestMethod.GET)
    public String showRedirect(){

        return "goto";
    }

    @RequestMapping(value = "/goto",method = RequestMethod.POST)
    public String goToPage(RedirectAttributes redirectAttributes){

        logger.info("RedirectController被调用");

        redirectAttributes.addFlashAttribute("message","wangbo");

        return "redirect:/jsp/redirect.jsp";
    }
}
