package command;

public enum Operation {
	INFO,
	CHOOSE,
	SHOW,
	SAVE,
	EXIT;
	
	public static Operation getOpByOrdinal(Integer i) {
		switch(i) {
		case 0:
			return INFO;
		case 1:
			return CHOOSE;
		
		case 2:
			return SHOW;
		case 3:
			return SAVE;
		case 4:
			return EXIT;
			
		}
		
	return null;
	

}
}
