package command;

import model.Model;
import view.View;

public class ChooseArt implements Command {
	
	
	private Model model;
	private View view;
	public ChooseArt(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	@Override
	public void execute() {
		Integer art = view.readInt();
		Integer pos = view.readInt();

	}

}
