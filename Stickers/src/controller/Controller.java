package controller;



import command.CommandExecutor;
import command.Operation;
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
		Operation op = null;
		do {
			op = view.askOperation();
			CommandExecutor.init(this.model, this.view);// инициализация коммандЭкзекутора моделью и вьюшкой
			//для передачи в команды этих полей
			CommandExecutor.execute(op);}
		while(op!=Operation.EXIT);
		//TODO -ввод команды и передача управления в команду

		
		
	}
	public static void main(String[] args) {
		Controller c = new Controller();
	}
	
	
	

}
