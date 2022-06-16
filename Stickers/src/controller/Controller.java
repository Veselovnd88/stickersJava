package controller;

import model.Model;

public class Controller {
	private Model model;
	
	
	public Controller() {
		this.model = new Model();
		model.getLabel();
		model.saveAll();
		
		
	}
	public static void main(String[] args) {
		Controller c = new Controller();
	}
	
	
	

}
