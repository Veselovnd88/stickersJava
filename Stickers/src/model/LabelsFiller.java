package model;

import java.util.ArrayList;
import java.util.List;

public class LabelsFiller {
	private List<Label> labels = new ArrayList<>();
	private static LabelsFiller instance;
	
	public static LabelsFiller getInstance() {
		if(instance==null) {
			return new LabelsFiller();
		}
		else return instance;
	}
	public List<Label> getLabels() {
		return labels;
	}
	
}
