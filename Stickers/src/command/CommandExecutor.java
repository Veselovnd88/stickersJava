package command;

import java.util.HashMap;
import java.util.Map;

import model.Model;
import view.View;

public class CommandExecutor {
	

	public static final Map<Operation, Command> allCommands = new HashMap<>();

	
	private CommandExecutor() {		
	}
	
	
	public static void init(Model model, View view) {
		allCommands.put(Operation.CHOOSE, new ChooseArt(model, view));
		allCommands.put(Operation.SHOW, new Show(model));
		allCommands.put(Operation.SAVE, new Save(model));

	}
	public static final void execute(Operation operation) {
		allCommands.get(operation).execute();
	}
	
	
	
	

}
