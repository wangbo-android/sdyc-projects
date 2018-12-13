package day0316;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class IOStreamPractise2 {

	
	public static void main(String[] args) {
		
		try {
			
			Process p = Runtime.getRuntime().exec("javac");
			
			InputStream is = p.getErrorStream();
			
			BufferedInputStream bis = new BufferedInputStream(is);
			
			byte[] buf = new byte[bis.available()];
			
			int hasRead = 0;
			
			while((hasRead = bis.read(buf)) > 0){
				
				System.out.println(buf);
			}
			
			File file = new File("E:" + File.separator + "test.txt");
			
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			
			raf.seek(raf.length());
			
			raf.write("×·¼ÓµÄÄÚÈÝ\r\n".getBytes());
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
