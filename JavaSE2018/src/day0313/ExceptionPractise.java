package day0313;

public class ExceptionPractise {

	public static void main(String[] args) {
		
		System.out.println(test());
	}
	
	public static boolean test(){
		
		try{
			
			System.out.println("try”Ôæ‰");
			
			return true;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			System.out.println("finnally");
			
			return false;
		}
	}

}
