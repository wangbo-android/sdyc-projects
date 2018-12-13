package day0309;

public class Fruit<T> {

	private T info;
	
	public Fruit(T info){
		
		this.info = info;
	}
	
	public T getInfo() {
		return info;
	}
}
