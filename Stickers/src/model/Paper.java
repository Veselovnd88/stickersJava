package model;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Paper {
	private final int WIDTH = 1240 ;
	private final int HEIGHT = 1754 ;
	private BufferedImage myImage;
	
	
	
	public Image createImage() {
		myImage = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	      Graphics g = myImage.getGraphics();
	      	      g.setColor(Color.YELLOW);
	      g.fillRect(0, 0, WIDTH, HEIGHT);
	      return myImage;
	}
	
	public void draw(Image im) {
		createImage();
		Graphics g = myImage.getGraphics();
		g.drawImage(im, 200, 200, null);
		//g.drawImage(im, HEIGHT, HEIGHT, WIDTH, HEIGHT, null, null)
		
		
	}
	
	public void save() {
// тестовый метод для сохранения листа А4
		File file = new File("src/controller/outfile/"+"paper".
				replace(' ', '_') + ".jpg");
		System.out.println(file.toString());
	   	BufferedImage bi = (BufferedImage) myImage;
	   	try {
	   	
	   	ImageIO.write(bi, "jpg", file);}
	   	catch (IOException e) {
	   		e.printStackTrace();
	   	}
	}

}
