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
		System.out.println("Выберите артикул");
		System.out.println("1- 20.11 1 MPa \n"
				+ "2- 20.11 10 bar \n"+
				"3 - 20.11 6 bar\n"+
				"4 -20.11 0.6 Mpa"
				);
		int art = view.readArt();
		System.out.println("Выберите позицию для этикетки \n"+
		"1  2  3  4  \n5  6  7  8\n9  10 11 12");
		int pos = view.readPos();
		System.out.println("Введите серийный номер");
		String serial = view.readSerial();
		String name="";
		String range="";
		String pinout="";
		
		if(art==1) {
			name = "ADZ-SML-20.11";
			range = "1 MPa    0.5...5V";
			pinout = "1+, 2-, 3 Out, 4 Gehause";}
		if(art==2) {
			name = "ADZ-SML-20.11";
			range = "10 bar    0.5...5V";
			pinout = "1+, 2-, 3 Out, 4 Gehause";
		}
		if (art==3) {
			name = "ADZ-SML-20.11";
			range = "6 bar    0.5...5V";
			pinout = "3+, 2-, 1 Out";
		}
		if (art==4) {
			name = "ADZ-SML-20.11";
			range = "0.6 MPa    0.5...5V";
			pinout = "1+, 2-, 3 Out, 4 Gehause";
		}
			
			
			Label lab = LabelFactory.getLabel(name,range,pinout,serial);
			//TODO проверять наличие этикеток на позициях и спрашивать пользователя о перезаписи
			
			model.getMap().put(pos, lab);
			//System.out.println(model.getMap());//FIXME			
			//Paper paper = model.getPaper();
			//paper.draw(lab.createImage(), 100,100);//FIXME
			//paper.placeAll(model.getMap());
			//paper.save();//FIXME
		
		
	}

}
