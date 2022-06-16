package command;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import model.Label;
import model.LabelFactory;
import model.LabelsFiller;

public class Command801877 implements Command{
	
	private String name = "ADZ-SML-20.11";
	private String range = "1 MPa    0.5...5V";
	private String pinout = "1+,2-,3 Out,4 Gehause";
	private String serial;
	
	public Command801877(String serial) {
		this.serial = "SN: "+serial;
	}
	
	

	public String getName() {
		return name;
	}

	public String getRange() {
		return range;
	}

	public String getPinout() {
		return pinout;
	}

	public String getSerial() {
		return serial;
	}



	@Override
	public void execute() {
		System.out.println("Введите серийный номер");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String serial_ = br.readLine();
		this.serial +=serial_;
		LabelsFiller lf = LabelsFiller.getInstance();
		Label lb =  model.LabelFactory.getLabel(this.name,this.range,this.pinout, this.serial);
		
		
	}



	private Label LabelFactory.getLabel(String name2, String range2, String pinout2, String serial2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
