package view;

import command.Operation;
import javafx.scene.control.TextArea;

public interface View<T> {
	boolean YesOrNo();
	Integer readOp();
	Integer readPos();
	String readSerial();
	Operation askOperation();
	Integer readArt();
	void sendMessage(T source, String message);

}
