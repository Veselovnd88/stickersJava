package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ConsoleView extends View {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in,
			Charset.forName("UTF-8")));
	
	
	public void init() {
		System.out.println("Choose art 1- 801877, 2- 806122 ляляля kakaka");
		
	}

	@Override
	public Integer readArt() {
				try {
					Integer i = Integer.parseInt(br.readLine());
					return i;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

}
