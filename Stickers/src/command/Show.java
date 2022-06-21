package command;

import java.util.Map;

import model.Label;
import model.Model;

public class Show implements Command {
	private Model model;
	
	
	public Show(Model model) {
		this.model = model;
	}
	@Override
	public void execute() {
		System.out.println("Готово к печати:");
		for(Map.Entry<Integer,Label> entry: model.getMap().entrySet()) {
			System.out.printf("Номер позиции %d : Датчик %s %s с номером %s",entry.getKey(), 
					entry.getValue().getName(),entry.getValue().getRange(),
					entry.getValue().getSerial());	
			System.out.println();
		}
		
	}

}
