//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Commands.EmployeeManagementCommands;

import java.time.LocalDate;

import AuthenticationSystem.EmployeeDatabase;
import Employee.Employee;
import Employee.Role;
import Employee.SenorityLevel;
import IO.Input;
import Interfaces.Command;
import Logger.Logger;

public class CreateNewEmployeeCommand implements Command {

	@Override
	public void execute() {
		boolean userCreated = false;

		while (!userCreated) {
			int id = Input.getIDFromUser();
			String firstName = Input.getName("First name");
			String lastName = Input.getName("Last name");
			LocalDate birthdate = Input.getPastDate("Birthdate");
			Role role = Role.chooseRole();
			SenorityLevel level = SenorityLevel.chooseSenorityLevel();
			String username = Input.getString("Username");
			String password = Input.getString("Password");
			if(EmployeeDatabase.getInstance().addEmployee(new Employee(id, firstName, lastName, birthdate, role, level, username), password)) {
				Logger.log("Employee: ");
				Logger.log(EmployeeDatabase.getInstance().getEmployeeDetails(username).toString());
				Logger.log("has been created successfully");
				userCreated = true;
				
			}
			else {
				Logger.error("User creation failed, please try again");
			}
			
		}
		
	}

}
