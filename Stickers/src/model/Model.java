package model;

import java.util.Map;

import exception.InterruptOperationException;

public interface Model {
	Map<Integer,Label> getMap();
	Paper getPaper();
	void save() throws InterruptOperationException;
	

}
