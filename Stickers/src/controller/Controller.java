package controller;



import model.Model;
import view.ConsoleView;
import view.View;

public class Controller {
	private Model model;
	private View view;
	
	
	public Controller() {
		this.model = new Model();
		this.view = new ConsoleView();
		view.init();
		
		
	}
	public static void main(String[] args) {
		Controller c = new Controller();
	}
	
	
	

}
