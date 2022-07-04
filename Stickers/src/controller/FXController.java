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
import javafx.scene.control.ToggleGroup;
import model.MainModel;
import model.Model;
import view.ConsoleView;
import view.GuiView;
import view.View;

public class FXController implements ControllerInt{ // implements Initializable {
	
	private Model model;
	private View view;
	
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
		
		onSave();
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
			
		System.out.println(selection.getText());
		
		onSetArt(art);
		int pos = 1;//chosenPos;//FIXME
		onSetPos(pos);
		

		CommandExecutor.execute(Operation.CHOOSE);
	}
	
	@Override
	public void onSetArt(int art) {
		model.setArt(art);
	}
	@Override
	public int onGetArt() {
		return model.getArt();
	}
	@Override
	public void onSetPos(int pos) {
		model.setPos(pos);
	}
	@Override
	public void onSave() throws InterruptOperationException {
		model.save();
	}
	
	
	@FXML
	public void initialize() {
		ObservableList<Integer> positions = FXCollections.observableArrayList(1,2,3,4,5,6,7,
				8,9,10,11,12);
		pos_btn.setItems(positions);
				
		
	}
	@Override
	public int onGetPos() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Model getModel() {
		
		return this.model;
	}
	@Override
	public boolean onYesOrNo() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String onReadSerial() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
	
	

}
