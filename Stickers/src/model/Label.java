package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Label extends AbstractLabel{
	//TODO - увеличить DPI
	
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
	
	      Font stringFont = new Font("Arial",Font.BOLD,13);//задаем стандартный шрифт
	      Font stringBold = new Font("Arial",Font.BOLD,15);//задаем жирный шрифт
	      this.g.setFont(stringFont);//установка обычного шрифта
	      this.g.setColor(Color.black);//установка цвета шрифта

	      this.g.drawString(range, 80,51);//рисуем диапазон
	      this.g.drawString(pinout, 80,72);//рисуем распиновку
	      this.g.drawString("SN: "+serial, 80,93);//рисуем серийный номер
	      this.g.setFont(stringBold);//устанавливаем жирный шрифт для рисования жирным
	      this.g.drawString(name, 80,30);//рисуем имя
	      this.g.drawString(super.MANUFACTURER, 80,115);//рисуем строку производителя
	      addSigns();//добавляем значки
	      return this.bufferedImage;//возвращаем наше изображение
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
