package IO;

import Employee.Role;
import Employee.SenorityLevel;
import Logger.Logger;

public class Output {
	
	public static void printRoles(){
		for (Role role : Role.values()) {
			Logger.log(role.getIndex() + ". " + role.getName());
		}
	}
	
	public static void printSenorityLevels(){
		for (SenorityLevel level : SenorityLevel.values()) {
			Logger.log(level.getIndex() + ". " + level.getName());
		}
	}
	
}
