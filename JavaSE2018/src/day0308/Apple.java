package day0308;

public class Apple<T> {

	private T info;
	
	public Apple(T info){
		
		this.info = info;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
}
