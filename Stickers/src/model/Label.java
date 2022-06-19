package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Label extends AbstractLabel{
	
	protected static final int WIDTH = 200;//TODO изменить на корректные и правильные исходя из DPI 150
	protected static final int HEIGHT = 80;
	BufferedImage bufferedImage;
	Graphics g;
	
	
	public Label(String name, String range, String pinout, String serial) {
		this.name = name;
		this.range = range;
		this.pinout = pinout;
		this.serial = serial;
		this.bufferedImage = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		this.g = this.bufferedImage.getGraphics();
	    this.g.fillRect(0, 0, 200, 200);
		
		
	}
	
	public void addSigns() {
		File eacFile = new File("src/resources/EAC.png");
		File rosreestrFile = new File("src/resources/reestr.png");

		try {
			BufferedImage eac = ImageIO.read(eacFile);
			BufferedImage ros = ImageIO.read(rosreestrFile);
			g.drawImage(eac.getScaledInstance(40, 40, Image.SCALE_DEFAULT), 160, 0, null);
			g.drawImage(ros.getScaledInstance(40, 40, Image.SCALE_DEFAULT),160,40,null);
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	@Override
	public Image createImage() {
	      //Graphics g = bufferedImage.getGraphics(); 
	      Font stringFont = new Font("Arial",Font.PLAIN,12);
	      Font stringBold = new Font("Arial",Font.BOLD,12);
	      this.g.setFont(stringFont);
	      this.g.setColor(Color.black);
	      this.g.drawString(name, 30,15);
	      this.g.drawString(range, 30,30);
	      this.g.drawString(pinout, 30,45);
	      this.g.drawString("SN: "+serial, 30,60);
	      this.g.setFont(stringBold);
	      this.g.drawString(super.MANUFACTURER, 30,75);
	      addSigns();
	      return bufferedImage;
	}
	
	public String getSerial() {
		return this.serial;
	}

}
