package day0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class SocketHttpPractise {

	public static void main(String[] args) {
		
		try {
			
			socket2Http();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	private static void socket2Http() throws IOException{
		
		InetAddress address = InetAddress.getByName("www.baidu.com");
		
		Socket s = new Socket(address.getHostAddress(),80);
		
		s.setSoTimeout(10000);
		
		//s.shutdownOutput();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8"));
		
		String buff = null;
		
		String result = "";
		
		while((buff = br.readLine()) != null){
			
			result += buff;
		}
		
		System.out.println(result);
	}

}
