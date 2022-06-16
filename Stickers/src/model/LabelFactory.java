package model;

public class LabelFactory {
	
	private LabelFactory() {
		
	}
	
	public static Label getLabel(String name, String range, String pinout, String serial) {
		return new Label(name,range,pinout,serial);
	}

}
