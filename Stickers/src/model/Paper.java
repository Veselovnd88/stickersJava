package model;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import exception.InterruptOperationException;


public class Paper {
	private final int WIDTH = 1240 ;//размер взят для DPI 150
	private final int HEIGHT = 1754 ;
	
	private final static int LABELWIDTH = Label.WIDTH;
	private final static int LABELHEIGHT = Label.HEIGHT;
	private static final int LEFTEDGE = 59;
	
	private static final HashMap<Integer, List<Integer>> coordinates = new HashMap<>();//мапа с координатами и позициями
		
	private BufferedImage myImage;
	private Graphics g;

	
	static {//статик блок для инициализации координатами мапы
		for (int i=1; i<13;i++) {//13 - 12 позиций
			coordinates.put(i, new ArrayList<Integer>());
			if(i<5) {
				coordinates.get(i).add(LABELHEIGHT);
				if(i==1) {
				coordinates.get(i).add((LEFTEDGE+(i-1)*LABELWIDTH));}//59 расстояние от левого края
				else {
					coordinates.get(i).add(16*(i-1)+LEFTEDGE+(i-1)*LABELWIDTH);//17 расстояние между этикетками
				}					
			}
			else if(i>=5&& i<9) {
				coordinates.get(i).add(LABELHEIGHT*2);
				if(i==5) {
				coordinates.get(i).add((LEFTEDGE+(i-5)*LABELWIDTH));}
				else {
					coordinates.get(i).add(16*(i-5)+LEFTEDGE+(i-5)*LABELWIDTH);
				}	
			}
			else if(i>=9&& i<13) {
				coordinates.get(i).add(LABELHEIGHT*3);
				if(i==9) {
				coordinates.get(i).add((LEFTEDGE+(i-9)*LABELWIDTH));}
				else {
					coordinates.get(i).add(16*(i-9)+LEFTEDGE+(i-9)*LABELWIDTH);
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
	//метод размещает все этикетки по координатам и рисует на данном Image
	public void placeAll(Map<Integer,Label> labels) {
		for(Map.Entry<Integer, Label> entry: labels.entrySet()) {
			int x = coordinates.get(entry.getKey()).get(1);
			int y = coordinates.get(entry.getKey()).get(0);
			draw(entry.getValue().createImage(),x,y );
			
		}
	}
	
	
	public void save(String directory) throws InterruptOperationException {
	//	String windows = "c:\\StickersADZ";
		//String linux = "/home/nikolay/StickersADZ";
		Path path = Path.of(directory);//("c:\\StickersADZ");
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String timeStamp = formater.format(date);
		Path file = Path.of(directory+"/_sticker_"+timeStamp+".jpg");
		try {
			if(!Files.exists(path)) {
				System.out.println(path.getFileName());
				Files.createDirectory(Path.of(directory));}
			else {
				if(!Files.exists(file)) {
					file = Files.createFile(file);
				}
				
				BufferedImage bi = (BufferedImage) myImage;	
				ImageIO.write(bi, "jpg", file.toFile());}
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new InterruptOperationException();
		}
	}



	// сохранение в pdf
	public void savePdf() {
		File file = new File("src/controller/outfile/"+"paperPdf".
				replace(' ', '_') + ".pdf");

	}

}