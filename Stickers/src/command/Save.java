package command;

import exception.InterruptOperationException;
import model.Model;

public class Save implements Command {
	private Model model;
	
	public Save(Model model) {
		this.model = model;
	}
	@Override
	public void execute() throws InterruptOperationException {
		model.getPaper().placeAll(model.getMap());
		model.getPaper().save();
		
	}

}
