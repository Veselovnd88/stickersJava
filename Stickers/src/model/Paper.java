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

import org.apache.pdfbox.rendering.PDFRenderer;


public class Paper {
	private final int WIDTH = 1240 ;//размер взят для DPI 150
	private final int HEIGHT = 1754 ;
	
	private final static int LABELWIDTH = 270;//TODO поменять на статик от лейбла
	private final static int LABELHEIGHT = 125;
	
	private static final HashMap<Integer, List<Integer>> coordinates = new HashMap<>();//мапа с координатами и позициями
	
	
	private BufferedImage myImage;
	private Graphics g;

	//TODO сохранение сразу в пдф
	
	static {//статик блок для инициализации координатами мапы
		for (int i=1; i<13;i++) {//13 - 12 позиций
			coordinates.put(i, new ArrayList<Integer>());
			if(i<5) {
				coordinates.get(i).add(LABELHEIGHT);
				if(i==1) {
				coordinates.get(i).add((59+(i-1)*LABELWIDTH));}//59 расстояние от левого края
				else {
					coordinates.get(i).add(17*(i-1)+59+(i-1)*LABELWIDTH);//17 расстояние между этикетками
				}					
			}
			else if(i>=5&& i<9) {
				coordinates.get(i).add(LABELHEIGHT*2);
				if(i==5) {
				coordinates.get(i).add((59+(i-5)*LABELWIDTH));}
				else {
					coordinates.get(i).add(17*(i-5)+59+(i-5)*LABELWIDTH);
				}	
			}
			else if(i>=9&& i<13) {
				coordinates.get(i).add(LABELHEIGHT*3);
				if(i==9) {
				coordinates.get(i).add((59+(i-9)*LABELWIDTH));}
				else {
					coordinates.get(i).add(17*(i-9)+59+(i-9)*LABELWIDTH);
				}	
			}
			
		}
		
	}
	
	public Paper() {
		myImage = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		g = myImage.getGraphics();
	    g.setColor(Color.WHITE);
	    g.fillRect(0, 0, WIDTH, HEIGHT);
	}

	
	public void draw(Image im,int x, int y) {//рисует переданный имейдж на поле
		g.drawImage(im, x, y, null);
		
	}
	
	public void placeAll(Map<Integer,Label> labels) {
		for(Map.Entry<Integer, Label> entry: labels.entrySet()) {
			int x = coordinates.get(entry.getKey()).get(1);
			int y = coordinates.get(entry.getKey()).get(0);
			draw(entry.getValue().createImage(),x,y );
			System.out.println("Рисую картинку с координатами "+ x +" "+ y);//FIXME
		}
	}
	
	
	public void save() {
// тестовый метод для сохранения листа А4
		File file = new File("src/controller/outfile/"+"paper".
				replace(' ', '_') + ".jpg");
		System.out.println("Файл сохранен "+ file.toString());
	   	BufferedImage bi = (BufferedImage) myImage;
	   	try {
	   	
	   	ImageIO.write(bi, "jpg", file);}
	   	catch (IOException e) {
	   		e.printStackTrace();
	   	}
	}
	
	public void savePdf() {
		File file = new File("src/controller/outfile/"+"paperPdf".
				replace(' ', '_') + ".pdf");

	}

}
