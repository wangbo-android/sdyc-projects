package controller;

import entity.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import validator.ProductValidator;

@Controller
public class ProductController {

    private static final Log logger = LogFactory.getLog(ProductController.class);

    @RequestMapping(value = "/input-product")
    public String showProductPage(Model model){

        model.addAttribute("product",new Product());

        return "inputProduct";
    }

    @RequestMapping(value = "/add-product")
    public String addProduct(@ModelAttribute Product product, BindingResult bindingResult,Model model){

        ProductValidator pv = new ProductValidator();

        pv.validate(product,bindingResult);

        if(bindingResult.hasErrors()){

            FieldError fe = bindingResult.getFieldError();

            logger.info("Code:" + fe.getCode() + ", field:" + fe.getField());

            return "inputProduct";
        }

        model.addAttribute("product",product);

        return "productInfo";
    }
}
