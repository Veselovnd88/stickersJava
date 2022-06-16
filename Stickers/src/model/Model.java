package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Model {
	private List<Label> labels = new ArrayList<>();
		
	public void getLabels() {
		String name = "ADZ-SML-20.11";
		String range = "1 MPa    0.5...5V";
		String pinout = "1+,2-, 3 Out, 4 Gehause";
		String serial = "123456 123456";
		Label lab = LabelFactory.getLabel(name,range,pinout,serial);
		labels.add(lab);
	}
	
	//всё сохраняется в отдельную папку.
	//TODO собирать все Images в отдельный список и потом формировать один jpeg из всех объектов
	//консольный ввод - 3 варианта этикеток - где меняется только серийный номер
	//
	public void save() {
		while(labels.size()!=0) {
			Label label = labels.get(0);
			labels.remove(0);
			
			File file = new File("src/controller/outfile/"+label.getSerial().
					replace(' ', '_') + ".jpg");//не создается файл
			System.out.println(file.toString());
		   	BufferedImage bi = (BufferedImage) label.createImage();
		   	try {
		   	
		   	ImageIO.write(bi, "jpg", file);}
		   	catch (IOException e) {
		   		e.printStackTrace();
		   	}
	   	}
		
	}
		

}
