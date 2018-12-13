package day0301;

public class FunctionInterfacePractise {

	public void test(){
		
		Runnable r = () -> {
			
			for(int i=0;i<10;i++){
				
				System.out.println(i + "");
			}
		};
		
		//MyStringTest mst = String::substring;
		/*
		MyConveter mc = (String a) -> {
			
			Integer.valueOf(a);
		};
		*/
		//mc = Integer :: valueof;
		
	}
}
