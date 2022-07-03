package model;

import java.util.Map;

import exception.InterruptOperationException;

public interface Model {
	Map<Integer,Label> getMap();
	Paper getPaper();
	void save() throws InterruptOperationException;
	int getArt();
	int getPos();
	void setArt(int art);
	void setPos(int pos);
	

}
