package controller;

import java.net.URL;
import java.util.ResourceBundle;

import command.CommandExecutor;
import command.Operation;
import exception.InterruptOperationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.MainModel;
import model.Model;
import view.ConsoleView;
import view.GuiView;
import view.View;

public class FXController{ // implements Initializable {
	
	@FXML
	private Label mainLbl;
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
	
	
	
	
	
	private Controller controller;
	
	public FXController() {
		this.controller = new Controller();//вообще может сделать интерфейс контроллер или абстр
		View guiview = new GuiView();
		Model model = new MainModel();
		controller.setView(guiview);//вот это вью должно как то получать значения из FX
		controller.setModel(model);
		
		CommandExecutor.init(controller);
		
	}
	public void init() {
		ObservableList<Integer> positions = FXCollections.observableArrayList(1,2,3,4,5,6,7,
				8,9,10,11,12);
		pos_btn.setItems(positions);
	}
	@FXML
	public void onMouseSaveClick() throws InterruptOperationException {
		
		controller.onSave();
	}
	
	
	@FXML
	public void onMousePlaceClick() throws InterruptOperationException {
		int art =1; //1chosenRadiobutton;//FIXME
		controller.onSetArt(art);
		int pos = 1;//chosenPos;//FIXME
		controller.onSetPos(pos);
		

		CommandExecutor.execute(Operation.CHOOSE);
	}
	@FXML
	public void initialize() {
		ObservableList<Integer> positions = FXCollections.observableArrayList(1,2,3,4,5,6,7,
				8,9,10,11,12);
		pos_btn.setItems(positions);
	
		
	}
	
	
	
	
	

}
