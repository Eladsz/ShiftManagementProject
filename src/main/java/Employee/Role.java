package Employee;

import IO.Input;
import IO.Output;

public enum Role {
	
	WORKER 			(1, "Worker"),
	SHIFT_MANAGER 	(2, "Shift Manager"),
	MANAGER 		(3, "Manager"),
	ADMIN           (4, "Admin");
	
	private int index;
	private String name;
	
	Role(int index, String name){
		this.name = name;
		this.index = index;
	}
	
	public static Role chooseRole() {
		Output.printRoles();
		int choice = Input.getNumberInRange(1, Role.values().length, "Choose Role by number");
		for (Role role : Role.values()) {
			if (role.getIndex() == choice)
				return role;
		}
		return null;
		
	}

	public int getIndex() {
		return index;
	}

	public String getName() {
		return name;
	}
}



