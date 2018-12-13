package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageHidenObjectController {

    private static final Log logger = LogFactory.getLog(PageHidenObjectController.class);

    @RequestMapping(value = "/showHiden")
    public String showPage(){

        logger.info("show page controller");

        return "PageHidenObject";
    }
}
