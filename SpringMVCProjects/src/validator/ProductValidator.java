package validator;

import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import entity.Product;

public class ProductValidator implements Validator {

	public boolean supports(Class<?> kclass) {
		
		return Product.class.isAssignableFrom(kclass);
	}
	
	public void validate(Object target, Errors errors) {
		
		Product product = (Product)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "price.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productionDate", "productionDate.required");
		Float price = product.getPrice();
		
		if(price != null && price < 0){
			
			errors.rejectValue("price", "price.negative");
		}
		
		Date date = product.getProductionDate();
		
		if(date != null){
			
			if(date.after(new Date())){
				
				System.out.println("salah lagi");
				errors.rejectValue("productionDate", "productionDate.invalid");
			}
		}
	}
}
