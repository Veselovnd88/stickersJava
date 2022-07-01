package controller;



import command.CommandExecutor;
import command.Operation;
import exception.InterruptOperationException;
import model.MainModel;
import view.View;

public class Controller {//контроллер должен управлять view - выдавать на отображение данные, получать данные из модели, изменять данные в модели и так далее
	private MainModel model;
	private View view;
	
	
	public Controller() {
		//this.model = new Model();
		//this.view = new ConsoleView();

	}
	
	public void setView(View view) {
		this.view = view;
	}
	public void setModel(MainModel model) {
		this.model = model;
	}
	
	public void startConsole() {

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
	
	public 
	
	public int onReadArt() {
		return view.readArt();
	}
	
	
	
	public int onReadPos() {
		return view.readPos();
	}
	
	


	
	
	

}
