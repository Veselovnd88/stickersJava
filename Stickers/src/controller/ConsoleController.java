package controller;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Map;

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
							"4 - Окрыть папку "+
							"5 - Выйти";
			this.sendMessage(messageOp);
			while(true) {
					try {
						Integer i = Integer.parseInt(br.readLine().trim());
						if(i<6&&i>0) {
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
		
		return model.getArt();	
	}
	
	public boolean onYesOrNo() throws InterruptOperationException {
		String message = "Введите y - да, n - нет";
		sendMessage(message);
		while(true) {
			try {
				String answer = br.readLine();
				if(answer.equals("y")) {
					return true;
				}
				if(answer.equals("n")) {
					return false;
				}
				else {
					sendMessage("Неправильный ввод\n"+message);
				}
			} catch (IOException e) {
				throw new InterruptOperationException();
			}}
}
		
	public int onReadPos() {
		return -1;
	}
	public String onReadSerial() throws InterruptOperationException {
		sendMessage("Введите серийный номер");
		String serial="";
		while(true) {
		try {
			serial = br.readLine();
			break;
			
		} catch (IOException e) {
			throw new InterruptOperationException();
		}
		} return serial;

	}
	
	public void onSave() throws InterruptOperationException {
		CommandExecutor.execute(Operation.SAVE);
	}
	

	public int onGetPos() throws InterruptOperationException {
		int pos = -1;
		String messagePos = 
				"Выберите позицию для этикетки \n"+
				"1  2  3  4  \n5  6  7  8\n9  10 11 12";
		sendMessage(messagePos);
		while(true) {
		try {
			Integer i = Integer.parseInt(br.readLine().trim());
			if(i>0&&i<13) {
				pos = i;
				model.setPos(pos);
				break;
				}
			else {
				sendMessage("Введите позицию этикетки от 1 до 12");
			}
			} catch (IOException e) {
					throw new InterruptOperationException();
				}
			  catch(NumberFormatException nfe) {
					sendMessage("Введено не число");
					sendMessage(messagePos);
				}
		
		} return pos;
		
}
	@Override
	public int onGetArt() {
		Integer art = -1;
				String messageArt = 
					"Выберите артикул\n"+
					"1- 20.11 1 MPa \n" +
							"2- 20.11 10 bar \n"+
							"3 - 20.11 6 bar\n"+
							"4 -20.11 0.6 Mpa";
			sendMessage(messageArt);
			while(true){
					try {
						Integer i = Integer.parseInt(br.readLine().trim());
						if(i>0&&i<5) {
							art = i;
							model.setArt(art);
							break;
						}
						else {
							sendMessage("Выберите из списка от 1 до 4\n"+messageArt);
						}				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			  catch(NumberFormatException nfi) {
				sendMessage("Введено не число\n"+messageArt);
				continue;
					}
			}		
		
		return art;
}
	
	@Override
	public void sendMessage(String message) {
		view.sendMessage(System.out, message);
		
	}
	@Override
	public boolean checkForRewriting() throws InterruptOperationException {
		int pos = model.getPos();
		Map<Integer, model.Label> map = this.getModel().getMap();		
		while(true) {
		if(map.containsKey(pos)){
			sendMessage("Эта позиция занята "+map.get(pos).getName()+" "+
					map.get(pos).getSerial()+"\nПерезаписать?"
			);
			if(!this.onYesOrNo()) {
				this.sendMessage("Позиция не записана");
				return false;
			}
			
			pos = this.onReadPos();
			} else { break;}
		}

		return true;
	}
	


}