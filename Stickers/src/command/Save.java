package command;

import model.Model;

public class Save implements Command {
	private Model model;
	
	public Save(Model model) {
		this.model = model;
	}
	@Override
	public void execute() {
		//TODO путь куда сохранен, или окно с выбором пути куда сохранить
		model.getPaper().placeAll(model.getMap());
		model.getPaper().save();
		
	}

}