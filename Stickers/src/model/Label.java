package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Label extends AbstractLabel{
	//TODO - увеличить DPI...
	
	protected static final int WIDTH = 270;//
	protected static final int HEIGHT = 125;//
	BufferedImage bufferedImage;
	Graphics g;
	
	
	public Label(String name, String range, String pinout, String serial) {
		this.name = name;
		this.range = range;
		this.pinout = pinout;
		this.serial = serial;
		this.bufferedImage = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		this.g = this.bufferedImage.getGraphics();
	    this.g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
	}
	
	public void addSigns() {
		//File eacFile = new File("src/resources/EAC.png");
		
		//String test = "/EAC.png";
		//InputStream is = Label.class.getResourceAsStream(test);
		
		
		//File rosreestrFile = new File("src/resources/reestr.png");
		//File adzFile = new File ("src/resources/adz.png");
		try {
			
			BufferedImage eac = ImageIO.read(Label.class.getResourceAsStream("/EAC.png"));
			BufferedImage ros = ImageIO.read(Label.class.getResourceAsStream("/reestr.png"));
			BufferedImage adz = ImageIO.read(Label.class.getResourceAsStream("/adz.png"));
			g.drawImage(eac.getScaledInstance(40, 40, Image.SCALE_DEFAULT), 230, 20, null);
			g.drawImage(ros.getScaledInstance(40, 40, Image.SCALE_DEFAULT),230,75,null);
			g.drawImage(adz.getScaledInstance(80, 80, Image.SCALE_SMOOTH),0,30 , null);
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	@Override
	public Image createImage() {
	
	      //Graphics g = bufferedImage.getGraphics(); 
	      Font stringFont = new Font("Arial",Font.BOLD,13);
	      Font stringBold = new Font("Arial",Font.BOLD,15);
	      this.g.setFont(stringFont);
	      this.g.setColor(Color.black);
	      //g.fillRect(0,0,270,125);
	      //g.setColor(Color.WHITE);
	      

	      this.g.drawString(range, 80,51);
	      this.g.drawString(pinout, 80,72);
	      this.g.drawString("SN: "+serial, 80,93);
	      this.g.setFont(stringBold);
	      this.g.drawString(name, 80,30);
	      this.g.drawString(super.MANUFACTURER, 80,115);
	      addSigns();
	      return bufferedImage;
	}
	
	public String getSerial() {
		return this.serial;
	}
	public String getName() {
		return this.name;
	}
	public String getRange() {
		return this.range;
	}

}
