package day0226;

public class Recursive {

	private static long fn(long a){
		
		if(a == 0){
			
			return 1;
			
		}else if(a == 1){
			
			return 4;
			
		}else{
			
			return 2 * fn(a - 1) + fn(a - 2);
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(fn(10));
	}

}
