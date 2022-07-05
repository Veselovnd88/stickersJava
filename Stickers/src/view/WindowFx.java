package view;


import java.net.URL;

import controller.FXController;
/*VM arguments
 * --module-path C:\Users\VeselovND\Downloads\openjfx-18.0.1_windows-x64_bin-sdk\javafx-sdk-18.0.1\lib --add-modules=javafx.controls
 * */
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class WindowFx extends Application {
	@FXML 
	private ChoiceBox<Integer> pos_btn;
	@Override
	public void start(final Stage stage) throws Exception {
			FXMLLoader loader = new FXMLLoader();
			URL url = getClass().getClassLoader().getResource("gui.fxml");
			//System.out.println(url);
			loader = new FXMLLoader(url);
			
			loader.setLocation(url);
			FXController fxcont = new FXController();
		
			loader.setController(fxcont);
			

		///Stickers/resources/guiFx.fxml
		
		Pane root = (Pane) loader.load();
		
		stage.setScene(new Scene(root));
		stage.show();
		
	}

	
	
	public static void main(String[] args) {
		
		launch(args);
		
		
	}
}
