package entity;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class Image {

    private String name;

    private List<MultipartFile> iamges;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MultipartFile> getIamges() {
        return iamges;
    }

    public void setIamges(List<MultipartFile> iamges) {
        this.iamges = iamges;
    }
}
