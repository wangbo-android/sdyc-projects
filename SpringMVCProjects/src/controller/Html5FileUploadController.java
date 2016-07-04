package controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import domain.UploadedFile;

@Controller
public class Html5FileUploadController {

	private static final Log logger = LogFactory.getLog(Html5FileUploadController.class);
	
	@RequestMapping(value="/html5")
	public String inputProductPaper(Model model){
		
		model.addAttribute("upload", new UploadedFile());
		return "html5";
	}
	
	@RequestMapping(value="/file_upload")
	public void saveFile(HttpServletRequest request,@ModelAttribute("upload") UploadedFile uploadFile,BindingResult bindingResult,Model model){
		
		MultipartFile multipartFile = uploadFile.getMultipartFile();
		if(multipartFile == null && uploadFile==null){
			
			logger.info("yes");
			return;
			
		}else {
			
			logger.info(uploadFile);
			
		}
		String fileName = multipartFile.getOriginalFilename();
		
		try{
			
			File file = new File("E:" + File.separator + "images" + File.separator + fileName);
			
			if(!file.exists()){
				
				logger.info(file.getPath());
				file.createNewFile();
			}
			
			multipartFile.transferTo(file);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
