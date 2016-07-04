package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import validator.ProductValidator;
import entity.Product;

@Controller
public class ProductController {

	private static final Log logger = LogFactory.getLog(ProductController.class);
	
	@RequestMapping(value="/input_product")
	public String inputProduct(@ModelAttribute Product product,BindingResult bindingResult,Model model){
		
		model.addAttribute("product", new Product());
		return "product_Form";
	}
	
	@RequestMapping(value="/save_product",method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute Product product,BindingResult bindingResult,Model model){
		
		ProductValidator pv = new ProductValidator();
		pv.validate(product, bindingResult);
		
		if(bindingResult.hasErrors()){
			
			FieldError fe = bindingResult.getFieldError();
			logger.info("Code:" + fe.getCode() + ", field:" + fe.getField());
			return "product_Form";
		}
		
		model.addAttribute("product", product);
		return "product_Details";
	}
}
