package command;

import java.util.Map;

import controller.Controller;
import controller.ControllerInt;
import controller.FXController;
import model.Label;
import model.LabelFactory;

public class ChooseArt implements Command {
	private ControllerInt controller;
	public ChooseArt(ControllerInt fxController) {
		this.controller = fxController;
	}

	@Override
	public  void execute() {

		int art = controller.onGetArt();
		int pos = controller.onGetPos();
		Map<Integer, Label> map = controller.getModel().getMap();
		while(true) {
		if(map.containsKey(pos)){
			System.out.println("Эта позиция занята "+map.get(pos).getName()+" "+//output to chosen source
					map.get(pos).getSerial()+"\nПерезаписать?"
			);
			if(controller.onYesOrNo()) {
				break;
			}
			
			pos = controller.onGetPos();
			} else { break;}
		}

		System.out.println("Введите серийный номер");//FIXME output to chosen source
		String serial = controller.onReadSerial();
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
			controller.getModel().getMap().put(pos, lab);		
	}

}
