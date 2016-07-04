package controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResourceController {

	@RequestMapping(value="/upload")
	public void downloadResource(HttpServletRequest request,HttpServletResponse response){
		
		File file = new File("E:" + File.separator + "img" + File.separator + "11-11.pdf");
		System.out.println(file.getPath());
		if(file.exists()){
			
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment;filename=11-11.pdf");
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			OutputStream os = null;
			try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				os = response.getOutputStream();
				byte[] buffer = new byte[fis.available()];
				int length = 0;
				while((length = bis.read(buffer)) != -1){
					
					os.write(buffer, 0, length); 
				}
			} catch (Exception e) {
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
