package view;


/*VM arguments
 * --module-path C:\Users\VeselovND\Downloads\openjfx-18.0.1_windows-x64_bin-sdk\javafx-sdk-18.0.1\lib --add-modules=javafx.controls
 * */
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class WindowFx extends Application {

	@Override
	public void start(final Stage stage) throws Exception {
		StackPane root = new StackPane();//слой который растягивает все элементы

		
		Label lbl = new Label();
		lbl.setStyle("-fx-font-family: Arial; -fx-font-size: 16");
		lbl.setText("Выберите номенклатуру, позицию и нажмите Разместить");
		RadioButton rb1 = new RadioButton("20.11 1MPa");
		RadioButton rb2 = new RadioButton("20.11 0.6 MPa");
		RadioButton rb3 = new RadioButton("20.11 10 bar");
		RadioButton rb4 = new RadioButton("20.11 6 bar");
		ToggleGroup group = new ToggleGroup();
		rb1.setToggleGroup(group);
		rb2.setToggleGroup(group);
		rb3.setToggleGroup(group);
		rb4.setToggleGroup(group);
		TextField serialField = new TextField("2111301102003");
		
		TextArea showPrint = new TextArea("Готово к печати: ");//TODO ограничение по количество символов
		showPrint.setEditable(false);
		
		Button savebtn = new Button("Сохранить");
		
		
		
		
		root.setAlignment(Pos.TOP_CENTER);
		StackPane.setMargin(lbl,new Insets(10.0,0,0,10));
		StackPane.setMargin(rb1, new Insets(50,350,0,0));
		StackPane.setMargin(rb2, new Insets(50,150,0,0));
		StackPane.setMargin(rb3, new Insets(50,-50,0,0));
		StackPane.setMargin(rb4, new Insets(50,-250,0,0));
		StackPane.setMargin(savebtn, new Insets(100,350,0,0));
		StackPane.setMargin(serialField, new Insets(150,100,200,50));
		
		StackPane.setMargin(showPrint, new Insets(200,100,100,50));
		
		
		root.getChildren().addAll(lbl,rb1,rb2,rb3,rb4,savebtn,serialField,showPrint);

		savebtn.setOnAction(event-> {
			RadioButton rb = (RadioButton) group.getSelectedToggle();
			if (rb==null) {
				return;
			}
			savebtn.setText(rb.getText());
		});
		

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
