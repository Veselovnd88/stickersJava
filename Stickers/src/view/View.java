package view;

import command.Operation;

public abstract class View {
	public abstract Integer readOp();
	public abstract Integer readArt();
	public abstract Integer readPos();
	public abstract String readSerial();
	public abstract void init();
	public abstract Operation askOperation();

}
