package controller;

import entity.Employee;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

    private static final Log looger = LogFactory.getLog(EmployeeController.class);

    @RequestMapping(value = "/input-emp")
    public String inputEmp(Model model){

        model.addAttribute("emp",new Employee());

        return "employee";
    }

    @RequestMapping(value = "/add-emp")
    public String addEmp(@ModelAttribute("emp") Employee employee){

        looger.info(employee.getBirthDate().getClass().getName());

        return "redirect:/input-emp";
    }
}
