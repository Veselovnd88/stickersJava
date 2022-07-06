package controller;

import exception.InterruptOperationException;
import model.Model;

public interface ControllerInt {

	int onGetArt();

	void onSave() throws InterruptOperationException;
	int onGetPos();
	Model getModel();
	boolean onYesOrNo();
	String onReadSerial();
	void sendMessage(String message);
	boolean checkForRewriting(); //метод проверяет есть ли в мапе эта позиция или нет и перезаписывает
}