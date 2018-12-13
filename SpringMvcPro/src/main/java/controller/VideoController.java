package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class VideoController {

    @RequestMapping(value = "/mostViewed")
    public String getMostMovie(HttpServletRequest request, HttpServletResponse response){

        Integer id = (Integer) request.getAttribute("id");

        if(id == null){

            response.setStatus(500);

        }else if(id == 1){

            request.setAttribute("viewed",100);

        }else if(id == 2){

            request.setAttribute("viewed",200);
        }

        return "mostViewed";
    }

    @RequestMapping(value = "/latest/{putYear}")
    public ModelAndView getLatestTitles(@PathVariable String putYear){

        ModelAndView mav = new ModelAndView("Latest Titles");

        List<String> ls = new ArrayList<String>();

        if(putYear.equals("2016")){

            ls.add("wangbo");
            ls.add("lihe");

            mav.addObject("list",ls);
        }

        return mav;
    }
}
