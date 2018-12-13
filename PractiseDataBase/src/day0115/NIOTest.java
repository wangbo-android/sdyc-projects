package day0115;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class NIOTest {

	public static void main(String[] args) throws IOException {
		
		File file = new File("E:" + File.separator + "out.txt");
		
		System.out.println(System.currentTimeMillis());
		
		FileChannel fc = new FileInputStream(file).getChannel();
		
		MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
		
		Charset charset = Charset.forName("GBK");
		
		mbb.clear();
		
		CharBuffer cb = charset.decode(mbb);
		
		System.out.println(cb);
		
		System.out.println(System.currentTimeMillis());

	}

}
