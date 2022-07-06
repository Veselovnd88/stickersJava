package controller;

import exception.InterruptOperationException;
import model.Model;

public interface ControllerInt {

	int onGetArt() throws InterruptOperationException;

	void onSave() throws InterruptOperationException;
	int onGetPos() throws InterruptOperationException;
	Model getModel();
	boolean onYesOrNo();
	String onReadSerial() throws InterruptOperationException;
	void sendMessage(String message);
	boolean checkForRewriting(); //метод проверяет есть ли в мапе эта позиция или нет и перезаписывает
}