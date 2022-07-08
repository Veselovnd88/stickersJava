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
		String windows = "c:\\StickersADZ";
		String linux = "/home/nikolay/StickersADZ";
		
		String os = System.getProperty("os.name").toLowerCase();

		if(os.startsWith("windows")){
			try {
				Desktop.getDesktop().open(new File(windows));
			} catch (IOException e) {
				controller.sendMessage("Невозможно открыть папку");
				return;
			}
				}
		else {
			try {
				Desktop.getDesktop().open(new File(linux));
			} catch (IOException e) {
				controller.sendMessage("Невозможно открыть папку");
				return;
				
			}
			controller.sendMessage("Для "+ System.getProperty("os.name")+" не реализовано");
		}

	}

}
