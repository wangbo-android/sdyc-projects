package alltools;

public class Num2RMB {

	private static String[] hanArr = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
	
	private static String[] unitArr = {"十","百","千"};
	
	private static String[] maofenArr = {"毛","分"};
	
	private static String[] didive(double num){
		
		long zheng = (long)num;
		
		if(zheng >= 10000){
			
			throw new RuntimeException("数值不能大于10000");
		}
		
		long xiao = Math.round((num - zheng) * 100);
		
		return new String[]{zheng + "",String.valueOf(xiao)};
		
	}
	
	private static String toHanStr(String[] numStr){
		
		String result = "";
		
		String resultMaoFen = "";
		
		int numLen = numStr[0].length();
		
		int maofenLen = numStr[1].length();
		
		for(int i=0;i<numLen;i++){
			
			int num = numStr[0].charAt(i) - 48;
		
			if(i != numLen -1 && num != 0){
				
				result += hanArr[num] + unitArr[numLen - 2 - i];
				
			}else{
				
				if(i == numLen -1 && num == 0){
					
					result += "";
					
				}else{
					
					result += hanArr[num];
				}
			}
		}
		
		for(int i=0;i<maofenLen;i++){
			
			//12
			int num = numStr[1].charAt(i) - 48;
			
			resultMaoFen += hanArr[num] + maofenArr[i];
		}
		
		return "人民币：" + result + "元" + resultMaoFen;
	}
	
	public static void main(String[] args) {
			
		System.out.println(toHanStr(didive(5471111.7)));
	}

}
