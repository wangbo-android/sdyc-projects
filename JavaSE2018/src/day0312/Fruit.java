package day0312;

public class Fruit <T>{

	private T infos;
	
	public Fruit(T infos){
		
		this.infos = infos;
	}
	
	public T getInfos() {
		return infos;
	}
}
