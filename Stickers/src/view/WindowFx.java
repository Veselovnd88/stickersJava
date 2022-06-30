package view;
/*VM arguments
 * --module-path C:\Users\VeselovND\Downloads\openjfx-18.0.1_windows-x64_bin-sdk\javafx-sdk-18.0.1\lib --add-modules=javafx.controls
 * */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WindowFx extends Application {

	@Override
	public void start(final Stage stage) throws Exception {
		StackPane root = new StackPane();//слой который растягивает все элементы
		Pane pane = new Pane();
		
		Label lbl = new Label();
		lbl.setStyle("-fx-font-family: Arial; -fx-font-size: 16");
		lbl.setText("Выберите номенклатуру, позицию и нажмите Разместить");
		lbl.setLayoutX(20.0);
		lbl.setLayoutY(20.0);
		pane.getChildren().add(lbl);
		
		
		
		
		Scene scene = new Scene(root, 500,500);
		stage.setMinHeight(500);
		stage.setMinWidth(500);
		stage.setTitle("Stickers Program");
		stage.setScene(scene);
		stage.show();
		
	}
	
	
	public static void main(String[] args) {
		
		launch(args);
		
		
	}
}
