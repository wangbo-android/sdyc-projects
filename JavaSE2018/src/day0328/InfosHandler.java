package day0328;

public class InfosHandler {

	private int age;
	
	private String name;
	
	private String address;
	
	private double salary;
	
	private boolean isMarried;
	
	public InfosHandler(){
		
		System.out.println("无参数构造器");
	}
	
	public InfosHandler(String name){
		
		this.name = name;
		
		System.out.println("有" + this.name + "参数构造器");
	}
	
	public void infos(){
		
		System.out.println("infos方法");
	}
	
	public void infos(String name){
		
		this.name = name;
		
		System.out.println(this.name);
	}
	
	public void infos(String name,int age){
		
		this.name = name;
		this.age = age;
		
		System.out.println(this.name + this.age + "");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	
	private void test(String str){
		
		System.out.println("调用private方法" + str);
	}
}
