package view;

import command.Operation;
import javafx.scene.control.TextArea;

public class GuiView implements View<TextArea>{
	private int art;
	public int getArt() {
		return art;
	}

	public void setArt(int art) {
		this.art = art;
	}

	public boolean isYesNo() {
		return yesNo;
	}

	public void setYesNo(boolean yesNo) {
		this.yesNo = yesNo;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	private boolean yesNo;
	private int op;
	private int pos;
	private String serial;
	
	
	
	

	@Override
	public boolean YesOrNo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer readOp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer readArt() {
		
		return getArt();
	}

	@Override
	public Integer readPos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String readSerial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operation askOperation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendMessage(TextArea source, String message) {
		// TODO Auto-generated method stub
		
	}

}
