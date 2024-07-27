package Commands;

import java.time.LocalDate;

import AuthenticationSystem.EmployeeDatabase;
import Employee.Employee;
import Employee.Role;
import Employee.SenorityLevel;
import IO.Input;
import Interfaces.Command;
import Logger.Logger;

public class CreateNewUserCommand implements Command {

	@Override
	public void execute() {
		boolean userCreated = false;
		int id = Input.getIDFromUser();
		String firstName = Input.getName("First name");
		String lastName = Input.getName("Last name");
		LocalDate birthdate = Input.getDate();
		Role role = Role.chooseRole();
		SenorityLevel level = SenorityLevel.chooseSenorityLevel();
		while (!userCreated) {
			String username = Input.getString("Username");
			if(EmployeeDatabase.getInstance().addEmployee(new Employee(id, firstName, lastName, birthdate, role, level, username))) {
				Logger.log("Employee: ");
				Logger.log(EmployeeDatabase.getInstance().getEmployeeDetails(username).toString());
				Logger.log("has been created successfully");
				
			}
			else {
				Logger.error("User creation failed, please try again");
			}
			
		}
		
	}

}
