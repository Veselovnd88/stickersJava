package view;

import javafx.scene.control.TextArea;

public class GuiView implements View<TextArea>{

	@Override
	public void sendMessage(TextArea source, String message) {
		source.setText(message);
		
	}

}
