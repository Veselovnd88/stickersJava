package model;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;


public class Paper {
	private final int WIDTH = 1240 ;//размер взят для DPI 150
	private final int HEIGHT = 1754 ;
	private static final HashMap<Integer, List<Integer>> coordinates = new HashMap<>();//мапа с координатами и позициями
	
	
	private BufferedImage myImage;
	private Graphics g;

	//TODO сохранение сразу в пдф
	
	static {//статик блок для инициализации координатами мапы
		for (int i=1; i<13;i++) {
			coordinates.put(i, new ArrayList<Integer>());
			if(i<5) {
				coordinates.get(i).add(200);
				if(i==1) {
				coordinates.get(i).add((100+i*200));}
				else {
					coordinates.get(i).add(10+i*200);
				}					
			}
			else if(i>=5&& i<9) {
				coordinates.get(i).add(410);
				if(i==5) {
				coordinates.get(i).add((100+(i-4)*200));}
				else {
					coordinates.get(i).add(10+(i-4)*200);
				}	
			}
			else if(i>=9&& i<13) {
				coordinates.get(i).add(610);
				if(i==9) {
				coordinates.get(i).add((100+(i-8)*200));}
				else {
					coordinates.get(i).add(10+(i-8)*200);
				}	
			}
			
		}
		
	}
	
	public Paper() {
		myImage = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		g = myImage.getGraphics();
	    g.setColor(Color.YELLOW);//FIXME
	    g.fillRect(0, 0, WIDTH, HEIGHT);
	}

	
	public void draw(Image im,int x, int y) {
		g.drawImage(im, x, y, null);
		System.out.println(coordinates);
	}
	
	public void placeAll(Map<Integer,Label> labels) {
		for(Map.Entry<Integer, Label> entry: labels.entrySet()) {
			int x = coordinates.get(entry.getKey()).get(1);
			int y = coordinates.get(entry.getKey()).get(0);
			draw(entry.getValue().createImage(),x,y );
			System.out.println("рисую картинку с координатами "+ x +" "+ y);
		}
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
