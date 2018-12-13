package day0227;

public class ObjectPractise {

	private String name;
	
	private int age;
	
	public ObjectPractise(String name,int age){
		
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj == null){
			
			return false;
			
		}else if(obj == this){
			
			return true;
			
		}else if(obj.getClass() == ObjectPractise.class){
			
			ObjectPractise op = (ObjectPractise)obj;
			
			if(op.getName().equals(this.getName()) && op.getAge() == this.getAge()){
				
				return true;
			}
			
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		
		return this.getClass().getName() + "[" + "name=" + this.getName() + "]" + "[age=" + this.getAge() + "]";
	}
	
	public static void main(String[] args) {
		
		ObjectPractise op = new ObjectPractise("wangbo",29);
		
		System.out.println(op);
		
	}
}
