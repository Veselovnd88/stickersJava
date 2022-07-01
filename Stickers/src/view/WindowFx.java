package view;


import java.io.File;
import java.net.URL;

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
		FXMLLoader loader=null;
		try {
			
			File file = new File("resources/EAC.png");///Stickers/resources
			System.out.println(file.isFile());
			loader = new FXMLLoader(getClass().getResource("resources/guiFX.fxml"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		///Stickers/resources/guiFx.fxml
		
		AnchorPane root = loader.load();
		
		stage.setScene(new Scene(root));
		stage.show();
		
	}

	
	
	public static void main(String[] args) {
		
		launch(args);
		
		
	}
}
