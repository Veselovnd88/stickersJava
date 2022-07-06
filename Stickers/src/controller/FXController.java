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

public class FXController implements ControllerInt{ // implements Initializable {
	
	private Model model;

	private View<TextArea> view;
	

	@FXML
	private Label mainLbl;
	@FXML
	private Button folder_btn;
	@FXML
	private Button placeButton;
	@FXML 
	private Button SaveButton;
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

	private ControllerInt controller;
	
	public FXController() {
		//this.controller = new Controller();//вообще может сделать интерфейс контроллер или абстр
		this.view = new GuiView();
		this.model = new MainModel();

		
		CommandExecutor.init(this);
		
	}
	public void init() {
		ObservableList<Integer> positions = FXCollections.observableArrayList(1,2,3,4,5,6,7,
				8,9,10,11,12);
		pos_btn.setItems(positions);
	}
	@FXML
	public void onMouseSaveClick() throws InterruptOperationException {
		CommandExecutor.execute(Operation.SAVE);
		
	}
	
	@FXML
	private void onMouseShowClick() throws InterruptOperationException {
		CommandExecutor.execute(Operation.SHOW);
	}
	
	@FXML
	private void onOpenFolderClick() throws IOException {
		//	Desktop.getDesktop().open(new File("c:\\StickersADZ"));
		this.sendMessage("Файл для печати находится тут c:\\StickersADZ");
		
	}
	
	@FXML
	public void onMousePlaceClick() throws InterruptOperationException {
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
		
		onSetArt(art);				
		int pos = pos_btn.getValue();
		onSetPos(pos);
		CommandExecutor.execute(Operation.CHOOSE);
	}
	
	@Override
	public void onSetArt(int art) {//устанавливает значение артикула от пользователя
		model.setArt(art);
	}
	
	@Override
	public int onGetArt() {//забирает артикул из модели - для размещения
		return model.getArt();
	}
	
	@Override
	public void onSetPos(int pos) {//устанавливает позицию для размещения
		model.setPos(pos);
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
		if(model.getMap().isEmpty()) {
			this.sendMessage("Список для печати пустой, печатать нечего");
			return;
		}//проверка на пустую мапу, если ничего не добавлено
		model.save();
		sendMessage("Файл сохранен в директорию c:\\StickersADZ");
	}
	
	@FXML
	public void initialize() {
		ObservableList<Integer> positions = FXCollections.observableArrayList(1,2,3,4,5,6,7,
				8,9,10,11,12);
		pos_btn.setItems(positions);
		pos_btn.setValue(1);
		text_area.setPrefRowCount(14);
		//text_area.setText("1 \n 2\n 3\n 4\n 5\n 6\n 7\n 8\n 9\n 10\n 11\n 12\n");
		
	}

	@Override
	public Model getModel() {
		
		return this.model;//FIXME есть вопросы наверное с моделью только тут должны быть манипуляции
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
		return serial_area.getText();
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
		return true;
	}
}