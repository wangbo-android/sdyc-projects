package day0308;

public class Student extends Person{

	private String info;
	
	public Student(String info){
		
		super(info);
		
		this.info = info;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}
	
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}
}
