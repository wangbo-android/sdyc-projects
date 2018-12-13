package day0312;

public class Apple <T extends Number>{

	private T infos;
	
	public Apple(T infos){
		
		this.infos = infos;
	}
	
	public T getInfos() {
		return infos;
	}
}
