package command;

import controller.Controller;
import exception.InterruptOperationException;

public class Save implements Command {
	private Controller controller;

	
	public Save(Controller controller) {
		this.controller = controller;
		}
	@Override
	public void execute() throws InterruptOperationException {
		controller.onSave();
		
	}

}
