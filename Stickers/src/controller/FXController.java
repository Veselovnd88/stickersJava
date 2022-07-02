package controller;

import command.CommandExecutor;
import command.Operation;
import exception.InterruptOperationException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.MainModel;
import model.Model;
import view.ConsoleView;
import view.GuiView;
import view.View;

public class FXController {
	
	@FXML
	private Label mainLbl;
	@FXML
	private Button placeButton;
	@FXML 
	private Button SaveButton;
	
	
	private Controller controller;
	
	public FXController() {
		this.controller = new Controller();
		View guiview = new GuiView();
		Model model = new MainModel();
		controller.setView(guiview);
		controller.setModel(model);
		
		CommandExecutor.init(controller);
		
	}
	@FXML
	public void onMouseSaveclick() throws InterruptOperationException {
		controller.onSave();
	}
	
	
	@FXML
	public void onMousePlaceClick() throws InterruptOperationException {
		CommandExecutor.execute(Operation.CHOOSE);
	}
	
	
	
	
	

}
