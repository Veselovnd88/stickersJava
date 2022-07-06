package view;

import java.io.PrintStream;

public class ConsoleView implements View<PrintStream> {
	@Override
	public void sendMessage(PrintStream source, String message) {
		source.println(message);
		
	}


	

}
