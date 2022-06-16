package model;

import java.awt.Graphics;
import java.awt.Image;

public abstract class AbstractLabel {
	
	protected String name;
	protected String range;
	protected String pinout;
	protected String serial;
	protected final String MANUFACTURER = "ADZ NAGANO GmbH";
	
	public abstract void paint(Graphics g);
	public abstract Image createImage();

}
