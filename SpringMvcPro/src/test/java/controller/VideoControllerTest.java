package controller;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.ModelAndViewAssert.*;
import static org.junit.Assert.*;

public class VideoControllerTest {
    @Test
    public void getLatestTitles() throws Exception {

        VideoController vc = new VideoController();
        ModelAndView mav = vc.getLatestTitles("2016");
        assertViewName(mav,"Latest Titles");
        assertModelAttributeAvailable(mav,"list");
        List<String> ls = new ArrayList<String>();
        ls.add("wangbo");
        ls.add("lihe");
        assertModelAttributeValue(mav,"list",ls);
    }

    @Test
    public void getMostMovie() throws Exception {

        VideoController vc = new VideoController();
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/mostViewed");
        request.setAttribute("id",1);
        MockHttpServletResponse response = new MockHttpServletResponse();
        vc.getMostMovie(request,response);
        assertEquals(200,response.getStatus());
        int viewed = (Integer) request.getAttribute("viewed");
        assertEquals(100,viewed);
    }

}