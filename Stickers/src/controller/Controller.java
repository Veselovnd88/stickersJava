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
		view.askOperation();//в цикл
		//TODO -ввод команды и передача управления в команду
		//в view -
		
		
	}
	public static void main(String[] args) {
		Controller c = new Controller();
	}
	
	
	

}
