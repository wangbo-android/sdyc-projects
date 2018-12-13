package day0308;

public class LittleApple extends Apple<String>{

	private String info;
	
	public LittleApple(String info) {
		
		super(info);
		
		this.info = info;
	}

	public String getInfo() {
		
		return info;
	}

	public void setInfo(String info) {
		
		this.info = info;
	}

}
