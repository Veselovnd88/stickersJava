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
		if(!controller.checkForRewriting())
		{
			return;//Проверка есть ли позиция или нет
		}
		/*if(map.containsKey(pos)){// если эта позиция уже занят то нужно спросить перезаписать или нет
			//
			//String message_execute = String.format("Эта позиция занята %s %s"//output to chosen source
					+"\nПерезаписать?",map.get(pos).getName(), map.get(pos).getSerial());
			
			controller.sendMessage(message_execute);
			//System.out.println("Эта позиция занята "+map.get(pos).getName()+" "+//output to chosen source
				//	map.get(pos).getSerial()+"\nПерезаписать?"
			//);
			if(!controller.onYesOrNo()) {
				controller.sendMessage("Позиция не записана");
				return;}
			}*/

	

		//System.out.println("Введите серийный номер");//FIXME output to chosen source
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
			controller.sendMessage(String.format("Размещена позиция %s %s %s"//output to chosen source
					,pos, map.get(pos).getName(), map.get(pos).getSerial()));
	}

}
