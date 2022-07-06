package controller;

import exception.InterruptOperationException;
import model.Model;

public interface ControllerInt {

	int onGetArt() throws InterruptOperationException;

	void onSave() throws InterruptOperationException;
	int onGetPos() throws InterruptOperationException;
	Model getModel();
	boolean onYesOrNo() throws InterruptOperationException;;
	String onReadSerial() throws InterruptOperationException;
	void sendMessage(String message);
	boolean checkForRewriting() throws InterruptOperationException; //метод проверяет есть ли в мапе эта позиция или нет и перезаписывает
}