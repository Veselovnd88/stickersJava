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
		
		Integer i = readInt();
		return Operation.getOpByOrdinal(i);
	}
	
	@Override
	public Integer readInt() {
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
