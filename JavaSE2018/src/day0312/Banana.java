package day0312;

public class Banana extends Fruit<String>{

	private String infos;
	
	public Banana(String infos){
		
		super(infos);
		
		this.infos = infos;
	}
	
	public String getInfos() {
		return infos;
	}
}
