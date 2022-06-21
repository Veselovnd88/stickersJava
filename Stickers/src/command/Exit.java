package command;

import exception.InterruptOperationException;

public class Exit implements Command {

	@Override
	public void execute() throws InterruptOperationException {
		throw new InterruptOperationException();
		
	}

}
