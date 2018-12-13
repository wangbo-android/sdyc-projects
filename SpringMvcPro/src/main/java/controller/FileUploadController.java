package controller;

import entity.Image;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class FileUploadController {

    private static final Log logger = LogFactory.getLog(FileUploadController.class);

    @RequestMapping(value = "/image-input")
    public String inputIamge(Model model){

        model.addAttribute("image", new Image());

        return "uploadImage";
    }

    @ModelAttribute(value = "/upload-image")
    public String saveImage(@ModelAttribute Image image,Model model){

        logger.info("go1");

        List<MultipartFile> iamges = image.getIamges();

        logger.info(iamges.size());

        if(iamges != null && iamges.size() >0){

            logger.info("go2");

            for(MultipartFile file : iamges){

                logger.info("go3");

                File fileImage = new File("E:" + File.separator + "image" + File.separator + file.getOriginalFilename());

                try {

                    logger.info("go4");

                    file.transferTo(fileImage);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        model.addAttribute("image",image);

        return "imageInfos";
    }
}
