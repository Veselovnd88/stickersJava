package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import command.Operation;

public class ConsoleView extends View {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	public void init() {
		
	}
	
	public Operation askOperation() {
		Integer i = readOp();
		return Operation.getOpByOrdinal(i);
	}
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
	public Integer readArt() {
		String messageArt = 
				"Выберите артикул\n"+
				"1- 20.11 1 MPa \n" +
						"2- 20.11 10 bar \n"+
						"3 - 20.11 6 bar\n"+
						"4 -20.11 0.6 Mpa";
		System.out.println(messageArt);
		while(true){
				try {
					Integer i = Integer.parseInt(br.readLine());
					if(i>0&&i<5) {
						return i;
					}
					else {
						System.out.println("Выберите из списка от 1 до 4\n"+messageArt);
					}				
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		  catch(NumberFormatException nfi) {
			System.out.println("Введено не число\n"+messageArt);
			continue;
				}
		}
	}
	@Override
	public Integer readOp() {
		String messageOp = "Выберите операцию 1 - Выбор номенклатуры,"
						+ " 2 - показать список того что печатаем, "
						+ "3 - сохранить в файл";
		System.out.println(messageOp);
		while(true) {
				try {
					Integer i = Integer.parseInt(br.readLine());
					if(i<4&&i>0) {
						return i;}
					else {
						System.out.println("Неправильно введен номер операции");
						System.out.println(messageOp);	
					}
					
					}catch(NumberFormatException nfe) {
						System.out.println("Введено не число");
						System.out.println(messageOp);
					}
				
				catch (IOException e) {
			e.printStackTrace();
		}}
	}

	@Override
	public Integer readPos() {//TODO ограничение ввода по позициям
		String messagePos = 
				"Выберите позицию для этикетки \n"+
				"1  2  3  4  \n5  6  7  8\n9  10 11 12";
		System.out.println(messagePos);
		try {
			Integer i = Integer.parseInt(br.readLine());
			return i;
			} catch (IOException e) {
					e.printStackTrace();
					return 0;
			}
	}

	@Override
	public String readSerial() {
		String serial=null;
		try {
			serial = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return serial;
	}

}
