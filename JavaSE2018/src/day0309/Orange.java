package day0309;

public class Orange extends Fruit<String>{

	private String infos;
	
	public Orange(String infos){
		
		super(infos);
		this.infos = infos;
	}
	
	public String getInfos() {
		return infos;
	}
}
