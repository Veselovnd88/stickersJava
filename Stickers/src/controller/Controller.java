package controller;



import command.CommandExecutor;
import command.Operation;
import exception.InterruptOperationException;
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
		try {
		do {
			op = view.askOperation();
			CommandExecutor.init(this.model, this.view);// инициализация коммандЭкзекутора моделью и вьюшкой
			//для передачи в команды этих полей
			CommandExecutor.execute(op);}
		while(op!=Operation.EXIT);}
		catch(InterruptOperationException e) {
			
			System.out.println("Программа завершена");
		}


		
		
	}
	public static void main(String[] args) {
		Controller c = new Controller();
	}
	
	
	

}
