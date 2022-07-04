package command;

import controller.Controller;
import controller.ControllerInt;
import controller.FXController;
import exception.InterruptOperationException;

public class Save implements Command {
	private ControllerInt controller;

	
	public Save(ControllerInt fxController) {
		this.controller = fxController;
		}
	@Override
	public void execute() throws InterruptOperationException {
		controller.onSave();
		
	}

}
