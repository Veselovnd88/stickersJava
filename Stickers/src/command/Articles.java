package command;

public enum Articles {
	A801877,
	A801910,
	A806122,
	A807372;
	
	
	public static Articles getArtByOrdinal(Integer i) {
		switch(i) {
		case 1:
			return A801877;
		
		case 2:
			return A801910;}
		return null;
	}
}

