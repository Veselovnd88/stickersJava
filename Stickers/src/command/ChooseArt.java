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
		int art = view.readArt();
		int pos = view.readPos();
		System.out.println("Введите серийный номер");
		String serial = view.readSerial();
		
		
		if(art==1) {
			String name = "ADZ-SML-20.11";
			String range = "1 MPa    0.5...5V";
			String pinout = "1+,2-, 3 Out, 4 Gehause";
			
			
			Label lab = LabelFactory.getLabel(name,range,pinout,serial);
			//TODO проверять наличие этикеток на позициях и спрашивать пользователя о перезаписи
			
			model.getMap().put(pos, lab);
			System.out.println(model.getMap());//FIXME
			
			Paper paper = new Paper();//FIXME
			paper.draw(lab.createImage());//FIXME
			paper.save();//FIXME
		}
		
	}

}
