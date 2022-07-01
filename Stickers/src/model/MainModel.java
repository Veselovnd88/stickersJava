package model;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

public class MainModel implements Model {
	
	
	
	private Map<Integer,Label> posLabels = new TreeMap<>();
	private Paper paper = new Paper();
	private List<Label> labels = new ArrayList<>();
	
	
	//собирает строки и передает их  фабрику для получения нужного объекта, и добавляет в список
	public void addLabel() {
		String name = "ADZ-SML-20.11";
		String range = "1 MPa    0.5...5V";
		String pinout = "1+,2-, 3 Out, 4 Gehause";
		String serial = "123456 123456";
		Label lab = LabelFactory.getLabel(name,range,pinout,serial);
		labels.add(lab);
	}
	public List<Label> getLabels(){
		return labels;
	}
	
	public Paper getPaper() {
		return this.paper;
	}
	
	public Map<Integer, Label> getMap(){
		return posLabels;
	}
	
	public void save(Label label) {
		//сохранение этикетки в файл
		File file = new File("src/controller/outfile/"+label.getSerial().
				replace(' ', '_') + ".jpg");
	   	BufferedImage bi = (BufferedImage) label.createImage();
	   	try {
	   	
	   	ImageIO.write(bi, "jpg", file);}
	   	catch (IOException e) {
	   		e.printStackTrace();
	   	}
	}
	

	public void saveAll() {
		while(labels.size()!=0) {
			Label label = labels.get(0);
			labels.remove(0);
			save(label);
	   	}
	}		
}
