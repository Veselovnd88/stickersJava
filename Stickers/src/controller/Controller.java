package controller;



import command.CommandExecutor;
import command.Operation;
import exception.InterruptOperationException;
import model.Model;
import view.View;

public class Controller implements ControllerInt {//контроллер должен управлять view - выдавать на отображение данные, получать данные из модели, изменять данные в модели и так далее
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
	
	public Model getModel() {
		return model;
	}
	
	public int onReadArt() {
		
		
		return view.readArt();//тут должен быть некий хелпер, который читает из источника значения
		
		
		
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
	
	public void onSetArt(int art) {
		model.setArt(art);
	}
	
	public void onSetPos(int pos) {
		model.setPos(pos);
	}
	public int onGetPos() {
		return model.getPos();
	}
	public int onGetArt() {
		return model.getArt();
	}
	@Override
	public void sendMessage(String message) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean checkForRewriting() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	


	
	
	

}
