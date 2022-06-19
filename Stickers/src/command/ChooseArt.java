package command;

import model.Label;
import model.LabelFactory;
import model.Model;
import model.Paper;
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
		System.out.println("Выберите артикул и позицию для этикетки");
		int art = view.readInt();
		int pos = view.readInt();
		
		if(art==1) {
			String name = "ADZ-SML-20.11";
			String range = "1 MPa    0.5...5V";
			String pinout = "1+,2-, 3 Out, 4 Gehause";
			String serial = "123456 123456";
			Label lab = LabelFactory.getLabel(name,range,pinout,serial);
			model.getMap().put(pos, lab);
			System.out.println(model.getMap());
			
			Paper paper = new Paper();
			paper.draw(lab.createImage());
			paper.save();
		}
		
	}

}
