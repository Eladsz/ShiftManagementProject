package Commands.EmployeeManagementCommands;

import java.lang.runtime.SwitchBootstraps;

import AuthenticationSystem.EmployeeDatabase;
import Employee.Employee;
import IO.Input;
import Interfaces.Command;
import Logger.Logger;

public class UpdateEmployeeCommand implements Command {

	@Override
	public void execute() {
		Employee employee = EmployeeDatabase.getInstance().findEmployee(Input.getIDFromUser("Enter the Employee ID"));
		
		printUpdateOptions();
		int option = Input.getNumberInRange(1, 6);
		
		switch (option) {
		case 1:{
			employee.setFirstName(Input.getName("Enter the first name"));
			employee.setLastName(Input.getName("Enter the last name"));
			break;
		}
		case 2:{
			
			break;
		}
		case 3:{
			
			break;
		}
		case 4:{
			
			break;
		}
		case 5:{
			
			break;
		}
		case 6:{
			
			break;
		}
		
		}
	}
	
	public void printUpdateOptions() {
		Logger.log("Please choose an option:");
		Logger.log("1. Update Name");
		Logger.log("2. Update Birthdate");
		Logger.log("3. Update Role");
		Logger.log("4. Update Senority level");
		Logger.log("5. Update Username");
		Logger.log("6. Update password");
	}

}
