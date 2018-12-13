package validator;

import entity.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import java.math.BigDecimal;

public class ProductValidator implements Validator{

    public boolean supports(Class<?> aClass) {

        return Product.class.isAssignableFrom(aClass);
    }

    public void validate(Object target, Errors errors) {

        Product product = (Product) target;

        ValidationUtils.rejectIfEmpty(errors,"name","productname.required");

        ValidationUtils.rejectIfEmpty(errors,"price","productprice.required");

        ValidationUtils.rejectIfEmpty(errors,"productDate","productDate.required");

        ValidationUtils.rejectIfEmpty(errors,"description","productDescription.required");

        BigDecimal price = product.getPrice();

        if(price != null && price.compareTo(BigDecimal.ZERO) < 0){

            errors.rejectValue("price","price.negative");

        }
    }
}
