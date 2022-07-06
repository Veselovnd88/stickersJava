package view;

import command.Operation;

public interface View <T>{
	boolean YesOrNo();
	String readSerial();
	Integer readArt();
	void sendMessage(T source, String message);

}