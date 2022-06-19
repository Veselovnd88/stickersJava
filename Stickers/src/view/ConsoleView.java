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
		System.out.println("Выберите операцию 1 - Выбор номенклатуры,"
		+ " 2 - показать список того что печатаем, "
		+ "3 - сохранить в файл");

		Integer i = readOp();

		return Operation.getOpByOrdinal(i);
	}
	
	@Override
	public Integer readArt() {//TODO сделать ограничение ввода по артикулам
				try {
					Integer i = Integer.parseInt(br.readLine());
					return i;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public Integer readOp() {//TODO сделать ограничение ввода по номерам операций
		while(true) {
				try {
					Integer i = Integer.parseInt(br.readLine());
					if(i<4&&i>0) {
						return i;}
					else {
						System.out.println("Неправильно введен номер операции");
						continue;
						
					}
					
					}catch(NumberFormatException nfe) {
						System.out.println("Введено не число");
						continue;
					}
				
				catch (IOException e) {
			e.printStackTrace();
		}}
	}

	@Override
	public Integer readPos() {//TODO ограничение ввода по позициям
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
