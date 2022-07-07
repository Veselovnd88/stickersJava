package command;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import controller.ControllerInt;
import exception.InterruptOperationException;

public class OpenFolder implements Command {
	ControllerInt controller;
	
	public OpenFolder(ControllerInt controller) {
		this.controller = controller;
	}
	@Override
	public void execute() throws InterruptOperationException {
		String os = System.getProperty("os.name").toLowerCase();

		if(os.startsWith("windows")){
			try {
				Desktop.getDesktop().open(new File("c:\\StickersADZ"));
			} catch (IOException e) {
				controller.sendMessage("Невозможно открыть папку");
				return;
			}
				}
		else {
			controller.sendMessage("Для "+ System.getProperty("os.name")+" не реализовано");
		}

	}

}
