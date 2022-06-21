package command;

import exception.InterruptOperationException;

public interface Command {
	public void execute() throws InterruptOperationException;
}
