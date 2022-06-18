package view;

import command.Operation;

public abstract class View {
	public abstract Integer readInt();
	public abstract void init();
	public abstract Operation askOperation();

}
