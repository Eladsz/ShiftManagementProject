//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Commands.LoginMenuCommands;

import java.time.LocalDate;

import AuthenticationSystem.EmployeeDatabase;
import AuthenticationSystem.UsersDatabase;
import Employee.Employee;
import IO.Input;
import Interfaces.Command;
import Logger.Logger;

public class ForgotPasswordCommand implements Command {

	@Override
	public void execute() {
		Logger.log("Enter your personal ID: ");
		int id = Input.getInt();
		String username = Input.getString("Username");
		LocalDate birthDate = Input.getPastDate("Birthdate");
		
		if (UsersDatabase.getInstance().isValidUser(username)) {
			Employee employee = EmployeeDatabase.getInstance().getEmployeeDetails(username);
			
			if (employee.getId() == id && employee.getBirthDate().equals(birthDate)) {
				Logger.log("Your password is: " + UsersDatabase.getInstance().getPassword(username));
				return;
			}
			else {
				Logger.error("Incorrect id or birthdate");
			}
			
		}
		else
			Logger.error("Incorrect username");
		
	}

}
