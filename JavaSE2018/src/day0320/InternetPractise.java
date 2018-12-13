package day0320;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InternetPractise {

	public static void main(String[] args) {
		
		try {
			
			InetAddress address = InetAddress.getByName("www.baidu.com");
			
			System.out.println(address.getHostName());
			
			System.out.println(Arrays.toString(address.getAddress()));
			
			String urlStr = URLEncoder.encode("·è¿ñJava½²Òå","utf-8");
			
			System.out.println(urlStr);
			
			String deStr = URLDecoder.decode(urlStr, "utf-8");
			
			System.out.println(deStr);
			
		} catch (UnknownHostException | UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
	}

}
