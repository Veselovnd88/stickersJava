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
	
	
	public void save() {
		while(labels.size()!=0) {
			Label label = labels.get(0);
			File file = new File("resources/"+label.getSerial() + ".jpg");//не создается файл
		   	BufferedImage bi = (BufferedImage) label.createImage();
		   	try {
		   	ImageIO.write(bi, "jpg", file);}
		   	catch (IOException e) {
		   		e.printStackTrace();
		   	}
	   	}
		
	}
		

}
