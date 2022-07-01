package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import command.Operation;
import controller.Controller;
import exception.InterruptOperationException;

public class ConsoleView extends View {
	private Controller contoller;
	
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	public Operation askOperation() {//запрос операции, в принципе всю функцию readOp можно перенести сюда
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
					Integer i = Integer.parseInt(br.readLine().trim());
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
						+ " 2 - Показать список того что печатаем, "
						+ "3 - Сохранить в файл "+
						"4 - Выйти";
		System.out.println(messageOp);
		while(true) {
				try {
					Integer i = Integer.parseInt(br.readLine().trim());
					if(i<5&&i>0) {
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
	//TODO где то должна быть статическая переменная определяющая количество этикеток
	@Override
	public Integer readPos() {//FIXME  - можно сделать до 16 этикеток
		String messagePos = 
				"Выберите позицию для этикетки \n"+
				"1  2  3  4  \n5  6  7  8\n9  10 11 12";
		System.out.println(messagePos);
		while(true) {
		try {
			Integer i = Integer.parseInt(br.readLine().trim());
			if(i>0&&i<13) {
				return i;}
			} catch (IOException e) {
					e.printStackTrace();//TODO пробрасывание исключения для завершения работы, в т.ч. на нуллы
				}
			  catch(NumberFormatException nfe) {
					System.out.println("Введено не число");
					System.out.println(messagePos);
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
}
