package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import command.Operation;

public class ConsoleView implements View<PrintStream> {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	

	@Override
	public boolean YesOrNo() {
		String message = "Введите y - да, n - нет";
		System.out.println(message);
		while(true) {
			try {
				String answer = br.readLine();
				if(answer.equals("y")) {
					return true;
				}
				if(answer.equals("n")) {
					return false;
				}
				else {
					System.out.println("Неправильный ввод\n"+message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



	@Override
	public String readSerial() {
		String serial=null;
		while(true) {
		try {
			serial = br.readLine();
			if(serial.length()!=0) {
				return serial;
			}
			System.out.println("Строка не может быть пустой");
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}


	@Override
	public void sendMessage(PrintStream source, String message) {
		source.println(message);
		
	}



	@Override
	public Integer readArt() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
