package controller;

import exception.InterruptOperationException;

public interface ControllerInt {
	void onSetArt(int art);
	void onSetPos(int pos);
	void onSave() throws InterruptOperationException;
}
