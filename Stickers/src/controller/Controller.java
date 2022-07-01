package controller;



import command.CommandExecutor;
import command.Operation;
import exception.InterruptOperationException;
import model.Model;
import view.View;

public class Controller {//контроллер должен управлять view - выдавать на отображение данные, получать данные из модели, изменять данные в модели и так далее
	private Model model;
	private View view;
	

	
	public void setView(View view) {
		this.view = view;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	
	public void startConsole() {

		Operation op = null;
		try {
		do {
			op = view.askOperation();
			CommandExecutor.init(this);// инициализация коммандЭкзекутора моделью и вьюшкой
			//для передачи в команды этих полей
			CommandExecutor.execute(op);}
		while(op!=Operation.EXIT);}
		catch(InterruptOperationException e) {
			
			System.out.println("Программа завершена");
		}
	}
	
	public Model getModel() {//FIXME interface Model
		return model;
	}
	
	public int onReadArt() {
		return view.readArt();
	}
	
	public boolean onYesOrNo() {
		return view.YesOrNo();
	}
	
	
	public int onReadPos() {
		return view.readPos();
	}
	public String onReadSerial() {
		return view.readSerial();
	}
	
	public void onSave() throws InterruptOperationException {
		model.save();
	}
	
	


	
	
	

}
