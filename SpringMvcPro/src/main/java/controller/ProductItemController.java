package controller;

import entity.ProductItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductItemController {

    @RequestMapping(value = "/input-item")
    public String inputItem(Model model){

        model.addAttribute("productItem",new ProductItem());

        return "inputItem";
    }
}
