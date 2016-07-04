package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import entity.ProductPapper;

@Controller
public class ProductPaperController {

	private static final Log logger = LogFactory.getLog(ProductPaperController.class);
	
	@RequestMapping(value="input_productpaper")
	public String inputProduct(Model model){
		
		model.addAttribute("productpaper", new ProductPapper());
		return "productPaperForm";
	}
	
	@RequestMapping(value="save_productpaper")
	public String saveProductPaper(Model model,HttpServletRequest servletRequest,@ModelAttribute("productpaper") ProductPapper productpaper,BindingResult bindingResult){
		
		List<MultipartFile> files = productpaper.getImages();
		List<String> fileNames = new ArrayList<String>();
		
		if(files != null && files.size() > 0){
			
			for(MultipartFile multipartFile : files){
				
				String fileName = multipartFile.getOriginalFilename();
				fileNames.add(fileName);
				logger.info(fileName);
				File imageFile = new File("E:" + File.separator + "images" + File.separator);
				try{
					if(!imageFile.exists()){
						
						logger.info(imageFile.getPath());
						imageFile.mkdir();
					}
					
					File image = new File(imageFile.getPath() + File.separator + fileName);
					
					if(!image.exists()){
						
						logger.info(image.getPath());
						image.createNewFile();
					}
					
					multipartFile.transferTo(image);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		model.addAttribute("productpaper",productpaper);
		
		return "productpaperDetails";
	}
}
