package day0224;

import java.util.Arrays;

public class ArrayPractise {

	private static int[] nums = null;
	
	public static void main(String[] args) {
		
		nums = new int[]{1,2,3,4,5};
		
		nums = new int[5];
		
		//���־�̬������ʽֻ���ڶ�������ͬʱ��ʼ������ʹ��
		int[] arr = {3,4,5,6,7};
		
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(arr));
	}

}
