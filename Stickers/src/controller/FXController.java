package controller;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import command.CommandExecutor;
import command.Operation;
import exception.InterruptOperationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.MainModel;
import model.Model;
import view.GuiView;
import view.View;

public class FXController implements ControllerInt{
	
	private Model model;
	private View<TextArea> view;
	@FXML
	private Label mainLbl;
	@FXML
	private Button folder_btn;
	@FXML
	private Button placeButton;
	@FXML 
	private Button saveButton;
	@FXML
	private Button delete_btn;
	@FXML
	private ChoiceBox<Integer> pos_btn;
	@FXML
	private TextArea text_area;
	@FXML
	private TextField serial_area;
	@FXML
	private RadioButton rb_1mpa;
	@FXML
	private RadioButton rb_06mpa;
	@FXML
	private RadioButton rb_10bar;
	@FXML
	private RadioButton rb_6bar;
	@FXML
	private ToggleGroup group1;

	public FXController() {
		this.view = new GuiView();//присваивается вью
		this.model = new MainModel();//основная модель
		CommandExecutor.init(this);
		
	}

	@FXML
	public void onMouseSaveClick() throws InterruptOperationException {
		CommandExecutor.execute(Operation.SAVE);//сохранение
		
	}
	
	@FXML
	private void onMouseShowClick() throws InterruptOperationException {
		
		CommandExecutor.execute(Operation.SHOW);//показать все
	}
	
	@FXML
	private void onOpenFolderClick() throws IOException, InterruptOperationException {
		CommandExecutor.execute(Operation.OPEN);
		
	}
	@FXML
	private void onMouseDeleteClick() {
		Map<Integer, model.Label> map = model.getMap();
		int pos = onGetPos();
		if (map.isEmpty()) {
			this.sendMessage("Еще ничего не добавлено");
			return;
		}
		if(map.containsKey(pos)) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Удаление позиции");
			alert.setHeaderText("Удалить позицию "+pos);
			alert.getButtonTypes().clear();
			ButtonType yes = new ButtonType("Да");
			ButtonType no = new ButtonType("Нет");			
			alert.getButtonTypes().addAll(yes, no);
		      Optional<ButtonType> option = alert.showAndWait();

		      if (option.get() == null) {
		    	  this.sendMessage("Ничего не выбрано, позиция не удалена");
		      } else if (option.get() == yes) {
		    	  map.remove(pos);
		    	  this.sendMessage(String.format("Позиция %s удалена",pos));
		      } else if (option.get() == no) {
		    	  this.sendMessage(String.format("Позиция %s не удалена", pos));
		      } 
		}
	}
	@FXML
	private void onClickHelpConsole() {
		Thread thread = new Thread(){
			@Override
			public void run() {
				new ConsoleController();
			}
		};
		thread.start();
	}
	
	@FXML
	private void onClickHelpAbout(){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Информация о программе");
		alert.setHeaderText("Программа для формирования листа с этикетками\n"
				+ "для датчиков давления\n"
				+ "Обратная связь: veselovnd@gmail.com");
		alert.show();
	}

	@FXML
	public void onMousePlaceClick() throws InterruptOperationException {//размещает этикетки на файле
		RadioButton selection = (RadioButton) group1.getSelectedToggle();
		String rbText = selection.getText();
		int art;
		switch(rbText) {
			case "20.11 1 MPa":
				art = 1;
				break;
			case "20.11 0.6 MPa":
				art = 2;
				break;
			case "20.11 10 bar":
				art = 3;
				break;
			case "20.11 6 bar":
				art = 4;
				break;
			default:art = 1;
			}
		
		model.setArt(art);		
		int pos = pos_btn.getValue();
		model.setPos(pos);
		CommandExecutor.execute(Operation.CHOOSE);
	}
	
	
	
	@Override
	public int onGetArt() {//забирает артикул из модели - для размещения
		return model.getArt();
	}
	
	@Override
	public int onGetPos() {//забирает позицию
		return model.getPos();
	}
	@Override
	public void sendMessage(String message) {//этот метод отправлять сообщение в вью
		view.sendMessage(text_area, message);
	}
	
	@Override
	public void onSave() throws InterruptOperationException {
		CommandExecutor.execute(Operation.SAVE);		
	}
	
	@FXML
	public void initialize() {
		ObservableList<Integer> positions = FXCollections.observableArrayList(1,2,3,4,5,6,7,
				8,9,10,11,12);
		pos_btn.setItems(positions);
		pos_btn.setValue(1);
		text_area.setPrefRowCount(14);		
	}

	@Override
	public Model getModel() {
		return this.model;
	}
	
	@Override
	public boolean onYesOrNo() {
		Alert alert = new Alert(AlertType.CONFIRMATION);//окошко с выбором
		alert.setTitle("Позиция которую вы хотите добавить уже существует");
		alert.setHeaderText("Перезаписать позицию");
		alert.getButtonTypes().clear();
		ButtonType yes = new ButtonType("Да");
		ButtonType no = new ButtonType("Нет");
		
		alert.getButtonTypes().addAll(yes, no);
	      Optional<ButtonType> option = alert.showAndWait();

	      if (option.get() == null) {
	    	  this.sendMessage("Ничего не выбрано, позиция не перезаписалась");
	        return false;
	      } else if (option.get() == yes) {
	    	  	         return true;
	      } else if (option.get() == no) {
	         return false;
	      } else {
	         return false;
	      }
	}
	
	@Override
	public String onReadSerial() {
		String serial = serial_area.getText();
		if (serial.length()==0) {
			Alert al = new Alert(AlertType.WARNING);
			al.setTitle("Предупреждение");
			al.setHeaderText("Нет серийного номера");
			al.show();			
			return null;
		}
		return serial ;
	}
	/*происходит проверка если на позиции уже есть элемент - и диалог - перезаписывать или нет*/
	
	@Override
	public boolean checkForRewriting() {
		int pos = onGetPos();
		Map<Integer, model.Label> map = this.getModel().getMap();		
		if(map.containsKey(pos)){// если эта позиция уже занят то нужно спросить перезаписать или нет			
			String message_execute = String.format("Эта позиция занята %s %s"//output to chosen source
					+"\nПерезаписать?",map.get(pos).getName(), map.get(pos).getSerial());			
			this.sendMessage(message_execute);
			if(!this.onYesOrNo()) {
				this.sendMessage("Позиция не записана");
				return false;}
			}
		return true;}
}
