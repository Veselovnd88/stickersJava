import controller.Controller;
import javafx.application.Application;
import model.MainModel;
import model.Model;
import view.ConsoleView;
import view.GuiView;
import view.View;
import view.WindowFx;

public class Main {

	public static void main(String[] args) {

		Controller c = new Controller();
		View view = new ConsoleView();
		View guiview = new GuiView();
		Model model = new MainModel();
		c.setView(guiview);
		c.setModel(model);
		
		Application.launch(WindowFx.class, args);
		
		//c.startConsole();
		
		
		
		
	}


}
