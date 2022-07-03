package model;


import java.util.Map;
import java.util.TreeMap;

import exception.InterruptOperationException;

public class MainModel implements Model {
	private int pos;
	private int art;
	
	
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
	@Override
	public int getPos() {
		return pos;
	}
	@Override
	public void setPos(int pos) {
		this.pos = pos;
	}
	@Override
	public int getArt() {
		return art;
	}
	@Override
	public void setArt(int art) {
		this.art = art;
	}

	


}
