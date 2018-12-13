package day0109;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class FileTest {

	public static void main(String[] args) throws IOException {
		
		File[] fileList = File.listRoots();
		
		for(File root : fileList){
			
			System.out.println(root);
		}
		
		File file = new File("E:\\");
		
		String[] lists = file.list();
		
		for(String list : lists){
			
			System.out.println(list);
		}
		
		Process p = Runtime.getRuntime().exec("javac");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		
		String buf = null;
		
		StringBuffer sb = new StringBuffer();
		
		while((buf = br.readLine()) != null){
			
			System.out.println(buf);
			
			sb.append(buf).append("\n");
		}
		
		PrintStream ps = new PrintStream(new FileOutputStream("E:" + File.separator + "out.txt"));
		
		System.setOut(ps);
		
		System.out.print(sb);
	}

}
