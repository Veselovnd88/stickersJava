package command;

public enum Operation {
	
	CHOOSE,
	SHOW,
	SAVE,
	EXIT;
	
	public static Operation getOpByOrdinal(Integer i) {
		switch(i) {
		case 0:
			return CHOOSE;
		
		case 1:
			return SHOW;
		case 2:
			return SAVE;
		case 3:
			return EXIT;
			
		}
		
	return null;
	

}
}
