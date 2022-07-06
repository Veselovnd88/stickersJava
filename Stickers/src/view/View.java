package view;

import command.Operation;

public interface View {
	boolean YesOrNo();
	Integer readOp();
	Integer readPos();
	String readSerial();
	Operation askOperation();
	Integer readArt();

}
