package view;

import command.Operation;

public abstract class View {
	public abstract boolean YesOrNo();
	public abstract Integer readOp();
	public abstract Integer readArt();
	public abstract Integer readPos();
	public abstract String readSerial();
	public abstract Operation askOperation();

}
