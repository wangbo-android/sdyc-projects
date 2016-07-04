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

import entity.Employee;

@Controller
public class EmployeeController{

	private static final Log logger = LogFactory.getLog(EmployeeController.class);
	
	@RequestMapping(value="/input_employee")
	public String inputEmployee(Model model){
		
		model.addAttribute("employee", new Employee());
		return "employeeForm";
	}
	
	@RequestMapping(value="/save_employee",method=RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee,Model model,BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			
			FieldError fe = bindingResult.getFieldError();
			logger.info("Code:" + fe.getCode() + ",field:" + fe.getField());
			return "employeeForm";
		}
		
		model.addAttribute("employee", employee);
		return "employeeDetails";
	}
	
}
