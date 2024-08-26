package Employee;

import IO.Input;
import IO.Output;

public enum SenorityLevel {
	STUDENT (1, "Student"),
	JUNIOR  (2, "Junior"),
	MID		(3, "Mid"),
	SENIOR	(4, "Senior"),
	EXPERT	(5, "Expert");
	
	private int index;
	private String name;
	
	SenorityLevel(int index, String name){
		this.index = index;
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public String getName() {
		return name;
	}
	
	public static SenorityLevel chooseSenorityLevel() {
		Output.printSenorityLevels();
		int choice = Input.getNumberInRange(1, SenorityLevel.values().length, "Choose Senority level by number");
		for (SenorityLevel level : SenorityLevel.values()) {
			if (level.getIndex() == choice)
				return level;
		}
		return null;
		
	}
}
