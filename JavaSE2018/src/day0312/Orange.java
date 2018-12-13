package day0312;

public class Orange<E> {

	private E desc;
	
	public <T> Orange(T infos,E desc){
		
		System.out.println(infos);
		
		this.desc = desc;
	}
	
	public E getDesc() {
		return desc;
	}
}
