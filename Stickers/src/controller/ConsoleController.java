package controller;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import command.CommandExecutor;
import command.Operation;
import exception.InterruptOperationException;
import model.MainModel;
import model.Model;
import view.ConsoleView;
import view.View;

public class ConsoleController implements ControllerInt {//контроллер должен управлять view - выдавать на отображение данные, получать данные из модели, изменять данные в модели и так далее
	private Model model;
	private View<PrintStream> view;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	
	public ConsoleController() {
		this.model = new MainModel();
		this.view = new ConsoleView();
		startConsole();
		
	}
	
	public void startConsole() {
		Operation op = null;
		try {
		do {
			op = askOperation();
			CommandExecutor.init(this);// инициализация коммандЭкзекутора моделью и вьюшкой
			//для передачи в команды этих полей
			CommandExecutor.execute(op);}
		while(op!=Operation.EXIT);}
		catch(InterruptOperationException e) {
			
			this.sendMessage("Программа завершена");
		}
	}
	
	private Operation askOperation() {//запрос операции, в принципе всю функцию readOp можно перенести сюда
			Integer op_num=-1;
			String messageOp = "Выберите операцию 1 - Выбор номенклатуры,"
							+ " 2 - Показать список того что печатаем, "
							+ "3 - Сохранить в файл "+
							"4 - Выйти";
			System.out.println(messageOp);
			while(true) {
					try {
						Integer i = Integer.parseInt(br.readLine().trim());
						if(i<5&&i>0) {
							op_num=i;
							break;}
						else {
							this.sendMessage("Неправильно введен номер операции");
							this.sendMessage(messageOp);	
						}
						
						}catch(NumberFormatException nfe) {
							this.sendMessage("Введено не число");
							this.sendMessage(messageOp);
						}
					catch (IOException e) {
				e.printStackTrace();
			}}
		return Operation.getOpByOrdinal(op_num);
	}
		
	
	public Model getModel() {
		return model;
	}
	
	public int onReadArt() {
		
		return view.readArt();//		
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
		view.sendMessage(System.out, message);
		
	}
	@Override
	public boolean checkForRewriting() {
		// TODO Auto-generated method stub
		return false;
	}
	


}