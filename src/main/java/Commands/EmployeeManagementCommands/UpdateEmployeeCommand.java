//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Commands.EmployeeManagementCommands;


import AuthService.EmployeeDatabase;
import Employee.Employee;
import Employee.Role;
import Employee.SenorityLevel;
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
			Logger.log("Name changed successfully");
			break;
		}
		case 2:{
			employee.setBirthDate(Input.getPastDate("Enter the birthdate"));
			Logger.log("Birthday changed successfully");
			break;
		}
		case 3:{
			employee.setRole(Role.chooseRole());
			Logger.log("Role changed successfully");
			break;
		}
		case 4:{
			employee.setLevel(SenorityLevel.chooseSenorityLevel());
			Logger.log("Senority level changed successfully");
			break;
		}
		case 5:{
			if(EmployeeDatabase.getInstance().changeUsername(employee, Input.getString("Enter the username")))
				Logger.log("Username changed successfully");
			else
				Logger.error("Change username - Failed");
			break;
		}
		case 6:{
			if (EmployeeDatabase.getInstance().changePassword(employee, Input.getString("Enter the old passowrd"), Input.getString("Enter the new passowrd")))
				Logger.log("Password changed successfully");
			else
				Logger.error("Change password - Failed");
				
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
