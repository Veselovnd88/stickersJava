import controller.Controller;
import model.MainModel;
import model.Model;
import view.ConsoleView;
import view.View;

public class Main {

	public static void main(String[] args) {

		Controller c = new Controller();
		View view = new ConsoleView();
		Model model = new MainModel();
		c.setView(view);
		c.setModel(model);
		c.startConsole();
		
		
		
		
	}


}
