package tests;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestInput {
	
	public static void main(String[] args) {
		
		

		InputStream backUp = System.in;
		
		
		String testStr = "1\n";
		ByteArrayInputStream bais = new ByteArrayInputStream(testStr.getBytes());
		System.setIn(bais);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String result = br.readLine();
			Integer i = Integer.parseInt(result);
			
			System.out.println(i);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
		
		
		
	}

}
