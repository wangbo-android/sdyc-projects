package day0318;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

@SuppressWarnings("resource")
public class IOStreamPractise {

	static{
		
		File file = new File("E:" + File.separator + "test.txt");
		
		try {
			
			FileInputStream fis = new FileInputStream(file);
			
			FileChannel fc = fis.getChannel();
			
			FileChannel out = new FileOutputStream("E:" + File.separator + "test.txt").getChannel();
			
			MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			
			Charset cr = Charset.forName("utf-8");
			
			CharsetDecoder decoder = cr.newDecoder();
			
			CharBuffer cb = decoder.decode(mbb);
			
			System.out.println(cb);
			
			//mbb.flip();
			
			out.write(mbb);
			
			mbb.clear();
			
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch(IOException e){
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		
	}

}
