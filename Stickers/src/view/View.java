package view;

import command.Operation;

public interface View <T>{
	boolean YesOrNo();
	Integer readOp();
	Integer readPos();
	String readSerial();
	Operation askOperation();
	Integer readArt();
	void sendMessage(T source, String message);

}