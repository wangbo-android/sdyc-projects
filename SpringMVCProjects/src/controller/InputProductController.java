package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InputProductController implements Controller{

	private static final Log logger = LogFactory.getLog(InputProductController.class);
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		
		logger.info("InputProductController called");
		String name = request.getParameter("name");
		System.out.println(name);
		return new ModelAndView("ProductForm");
	}
}
