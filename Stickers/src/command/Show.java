package command;

import java.util.Map;

import controller.Controller;
import controller.ControllerInt;
import controller.FXController;
import model.Label;

public class Show implements Command {
	private ControllerInt controller;
	public Show(ControllerInt fxController) {
		this.controller = fxController;
	}
	@Override
	public void execute() {
		Map<Integer, Label> map = controller.getModel().getMap();
		
		System.out.println("Готово к печати:");
		for(Map.Entry<Integer,Label> entry: map.entrySet()) {
			System.out.printf("Номер позиции %d : Датчик %s %s с номером %s",entry.getKey(), 
					entry.getValue().getName(),entry.getValue().getRange(),
					entry.getValue().getSerial());	
			System.out.println();
		}
		
	}

}
