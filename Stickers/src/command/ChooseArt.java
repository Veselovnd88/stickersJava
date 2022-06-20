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

		int art = view.readArt();		
		int pos = view.readPos();
		while(true) {
		if(model.getMap().containsKey(pos)){
			System.out.println("Эта позиция занята "+model.getMap().get(pos).getName()+" "+
					model.getMap().get(pos).getSerial()+"\nПерезаписать?"
			);
			if(view.YesOrNo()) {
				break;
			}
			
			pos = view.readPos();
			} else { break;}
		}

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
			model.getMap().put(pos, lab);		
	}

}
