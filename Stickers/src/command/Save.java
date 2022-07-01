package command;

import exception.InterruptOperationException;
import model.MainModel;

public class Save implements Command {
	private MainModel model;
	
	public Save(MainModel model) {
		this.model = model;
	}
	@Override
	public void execute() throws InterruptOperationException {
		model.getPaper().placeAll(model.getMap());
		model.getPaper().save();
		
	}

}
