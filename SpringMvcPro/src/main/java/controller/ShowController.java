package controller;

import entity.FormPageBean;
import entity.Student;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShowController {

    private static final Log logger = LogFactory.getLog(ShowController.class);

    private List<String> categoryList = new ArrayList<String>();

    @RequestMapping(value = "/show")
    public String showForm(Model model){

        model.addAttribute("student",new Student());

        return "form";
    }

    @RequestMapping(value = "/uploadInfo")
    public String loadInfos(@ModelAttribute Student student,Model model){

        String name = student.getName();

        int age = student.getAge();

        model.addAttribute("name",name);

        logger.info(age + name);

        return "done";
    }

    @RequestMapping(value = "/formPage")
    public String showFormPage(Model model){

        model.addAttribute("formPage",new FormPageBean());

        categoryList.add("是的");
        categoryList.add("不是的");
        categoryList.add("好的");

        model.addAttribute("categoryList",categoryList);

        return "tagpage";
    }

    @RequestMapping(value = "/getFormInfo")
    public String handleFormInfo(@ModelAttribute("formPage") FormPageBean formPageBean){

        logger.info(formPageBean.getCheck() + "\n" + formPageBean.getRadio());
        logger.info(formPageBean.getChecks());
        return "tagpage";
    }
}
