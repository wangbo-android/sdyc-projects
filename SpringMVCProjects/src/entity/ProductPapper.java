package entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductPapper {
	
	private String name;
	
	private String desciption;
	
	private List<MultipartFile> images;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public List<MultipartFile> getImages() {
		return images;
	}

	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}
	
}
