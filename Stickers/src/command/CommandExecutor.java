package command;

import java.util.HashMap;
import java.util.Map;

import exception.InterruptOperationException;
import model.MainModel;
import view.View;

public class CommandExecutor {
	

	public static final Map<Operation, Command> allCommands = new HashMap<>();

	
	private CommandExecutor() {		
	}
	
	
	public static void init(MainModel model, View view) {
		allCommands.put(Operation.CHOOSE, new ChooseArt(model, view));
		allCommands.put(Operation.SHOW, new Show(model));
		allCommands.put(Operation.SAVE, new Save(model));
		allCommands.put(Operation.EXIT, new Exit());

	}
	public static final void execute(Operation operation) throws InterruptOperationException {
		allCommands.get(operation).execute();
	}
	
	
	
	

}
