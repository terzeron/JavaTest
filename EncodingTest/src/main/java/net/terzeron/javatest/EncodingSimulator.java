package main.java.net.terzeron.javatest;

import java.io.UnsupportedEncodingException;


public class EncodingSimulator {
	static void print_bytes(String str, byte [] b) {
		System.out.print(str);
		for (int i = 0; i < b.length; i++) {
			System.out.print(String.format("%02X", ((int) b[i] & 0xFF)) + " ");
		}

		System.out.println("");
	}
	
	public static void main(String [] args) throws UnsupportedEncodingException {
		//Locale loc = Locale.KOREAN;
		
		String str0 = "가나다라마바사아자차카타파하 동해물과 백두산이 마르고 닳도록";
		System.out.println("str0=" + str0);
		
		// str0을 CP949로 encode한 byte열 (UCS4를 읽어서 --> CP949로 인코딩)
		byte [] b1 = str0.getBytes("CP949");
		print_bytes("b1=", b1);
		
		// b1을 UTF-8으로 decode한 문자열 (UTF-8로 읽어서 --> UCS4로 저장)
		String str1 = new String(b1, "UTF-8");
		System.out.println("str1=" + str1);		
		
		// str1을 UTF-8로 encode한 byte열 (UCS4를 읽어서 --> UTF-8으로 인코딩)
		byte [] b2 = str1.getBytes("UTF-8");
		print_bytes("b2=", b2);
		
		// b2를 CP949로 decode한 문자열 (CP949로 읽어서 --> UCS4로 저장)
		String str2 = new String(b2, "CP949");
		System.out.println("str2=" + str2);

		
		byte [] b3 = str2.getBytes("CP949");
		print_bytes("b3=", b3);
		
		String str4 = new String(b3, "UTF-8");
		System.out.println("str4=" + str4);
		
		byte [] b5 = str4.getBytes("UTF-8");
		print_bytes("b5=", b5);
		
		String str5 = new String(b5, "CP949");
		System.out.println("str5=" + str5);
		
		String x = "가나다라마바사";
		System.out.println(new String(x.getBytes("UTF-8"), "CP949"));
	}

}
