package controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ImageController {

	@RequestMapping(value="/image_get/{id}",method=RequestMethod.GET)
	public void getImage(@PathVariable String id,HttpServletResponse respnose,@RequestHeader String referer){
		
		System.out.println(referer);
		if(referer.equals("http://localhost:8080/SpringMVCProjects/jsp/showImages.jsp")){
			
			File file = new File("E:" + File.separator + "img" + File.separator + id + ".png");
			
			if(file.exists()){
				
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				OutputStream os = null;
				respnose.setContentType("image/jpg");
				try{
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					os = respnose.getOutputStream();
					byte[] buffer = new byte[fis.available()];
					int len = 0;
					
					while((len = bis.read(buffer)) != -1){
						
						os.write(buffer, 0, len);
					}
				} catch(Exception e){
					
					e.printStackTrace();
				} finally{
					
					try {
						fis.close();
						bis.close();
						os.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
			}
		}
	}
}
