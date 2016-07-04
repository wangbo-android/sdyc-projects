package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.ProductService;
import entity.Book;

@Controller
public class CustomerController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/context")
	public ModelAndView process(HttpServletRequest request,Model model){
		
		String param = request.getParameter("na);
		System.out.println(param);
		model.addAttribute("param", param);
		return new ModelAndView("context");
	}
	
	@RequestMapping(value="/view/{id}")
	public ModelAndView view(@PathVariable Long id,HttpServletRequest request,Model model,RedirectAttributes redirectAttributes){
		
		request.setAttribute("id", id);
		productService.view(id);
		redirectAttributes.addFlashAttribute("message", "successed");
		return new ModelAndView("redirect:/day1008/show.jsp");
	}
	
	@RequestMapping(value="/showView")
	public ModelAndView showView(@RequestParam int productId,Model model){
		
		System.out.println(productId);
		return new ModelAndView("view");
	}
	
	@RequestMapping(value="/saveParam")
	public ModelAndView saveParam(@RequestParam String param,Model model){
		
		System.out.println(param);
		return new ModelAndView("saveDone");
	}
	
	@ModelAttribute
	public String addParam(@RequestParam String param){
		
		System.out.println(param + "model");
		return param;
	}
	
	@RequestMapping(value="/saveBook",method=RequestMethod.POST)
	public ModelAndView saveBook(Model model){
		
		model.addAttribute("book",new Book());
		return new ModelAndView("showBook");
	}
	
	@RequestMapping(value="/message")
	public String viewMessage(@RequestParam String param){
		
		System.out.println(param);
		return "message";
	}
}
