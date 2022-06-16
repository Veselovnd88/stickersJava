package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Label extends AbstractLabel{
	
	protected static final int WIDTH = 200;
	protected static final int HEIGHT = 80;
	
	
	public Label(String name, String range, String pinout, String serial) {
		this.name = name;
		this.range = range;
		this.pinout = pinout;
		this.serial = serial;
	}
	
	@Override
	public void paint(Graphics g) {
	      Image img = createImage();
	      g.drawImage(img, 20,20,(ImageObserver) this);
		
	}

	@Override
	public Image createImage() {
		BufferedImage bufferedImage = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	      Graphics g = bufferedImage.getGraphics();
	      g.fillRect(0, 0, 200, 200);
	      Font stringFont = new Font("Arial",Font.PLAIN,12);
	      Font stringBold = new Font("Arial",Font.BOLD,12);
	      g.setFont(stringFont);
	      g.setColor(Color.black);
	      
	      g.drawString(name, 30,15);
	      
	      g.drawString(range, 30,30);
	      g.drawString(pinout, 30,45);
	      g.drawString(serial, 30,60);
	      
	      g.setFont(stringBold);
	      g.drawString(super.MANUFACTURER, 30,75);
	      
	      return bufferedImage;
	}
	
	public String getSerial() {
		return this.serial;
	}

}
