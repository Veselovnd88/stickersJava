package command;

import controller.ControllerInt;
import exception.InterruptOperationException;

public class Save implements Command {
	private ControllerInt controller;

	
	public Save(ControllerInt controller) {
		this.controller = controller;
		}
	@Override
	public void execute() throws InterruptOperationException {
		String os = System.getProperty("os.name").toLowerCase();
		
		
		
		if(this.controller.getModel().getMap().isEmpty()) {
			controller.sendMessage("Список для печати пустой, печатать нечего");
			return;
		}//проверка на пустую мапу, если ничего не добавлено
		if(os.startsWith("windows")){
			controller.getModel().save();
		controller.sendMessage("Файл сохранен в директорию c:\\StickersADZ");}
		else {
			controller.sendMessage("Для "+ System.getProperty("os.name")+" не реализовано");
		}
		
	}

}