package view;


import java.io.File;
import java.net.URL;

import controller.FXController;
import controller.FXController;
/*VM arguments
 * --module-path C:\Users\VeselovND\Downloads\openjfx-18.0.1_windows-x64_bin-sdk\javafx-sdk-18.0.1\lib --add-modules=javafx.controls
 * */
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WindowFx extends Application {

	@Override
	public void start(final Stage stage) throws Exception {
			FXMLLoader loader = new FXMLLoader();
			URL url = getClass().getClassLoader().getResource("gui.fxml");
			System.out.println(url);
			loader = new FXMLLoader(url);
			loader.setLocation(url);
			loader.setController(new FXController());
			

		///Stickers/resources/guiFx.fxml
		
		Pane root = (Pane) loader.load();
		
		stage.setScene(new Scene(root));
		stage.show();
		
	}

	
	
	public static void main(String[] args) {
		
		launch(args);
		
		
	}
}
