package model;


import java.util.Map;
import java.util.TreeMap;

import exception.InterruptOperationException;

public class MainModel implements Model {
	
	
	
	private Map<Integer,Label> posLabels = new TreeMap<>();
	private Paper paper = new Paper();//тут логика размещения этикеток на листе 


	@Override
	public Paper getPaper() {
		return this.paper;
	}
	
	@Override
	public Map<Integer, Label> getMap(){
		return posLabels;
	}

	@Override
	public void save() throws InterruptOperationException {
		
		if(posLabels.isEmpty()) {
			System.out.println("Список для печати пустой");
			return;
		}
		paper.placeAll(posLabels);
		paper.save();
		
	}

	


}
