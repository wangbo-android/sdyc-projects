package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class DownLoadController {

    private static final Log logger = LogFactory.getLog(DownLoadController.class);

    @RequestMapping(value = "/downLoad")
    public void downLoadFile(HttpServletRequest request, HttpServletResponse response){

       String path = request.getServletContext().getRealPath("/data");
       response.setContentType("application/pdf");
       response.setHeader("Content-Disposition","attachment; filename=secret.pdf");
       logger.info("开始下载");
        try {

            FileInputStream fis = new FileInputStream(new File(path + File.separator + "secret.pdf"));
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte[] bytes = new byte[bis.available()];
            bis.read(bytes);
            response.getOutputStream().write(bytes);

        } catch (FileNotFoundException e) {

            e.printStackTrace();
            throw new RuntimeException("文件没有找到");

        } catch (IOException e){

            e.printStackTrace();
            throw new RuntimeException("发生IO异常");
        }
    }
}
