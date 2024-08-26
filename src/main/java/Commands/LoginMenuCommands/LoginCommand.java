package Commands.LoginMenuCommands;

import AuthenticationSystem.AuthService;
import AuthenticationSystem.EmployeeDatabase;
import Employee.Employee;
import IO.Input;
import Interfaces.Command;
import Logger.Logger;
import Menu.MenuFactory;

public class LoginCommand implements Command {
	
	public static Employee loggedIn;
	
	@Override
	public void execute() {
		String username = Input.getString("Username");
		String password = Input.getString("Password");
		
		if (AuthService.getInstance().logIn(username, password)) {
			loggedIn = EmployeeDatabase.getInstance().getEmployeeDetails(username);
			Logger.log("Hello " + loggedIn.getFirstName() + " you are logged in!");
			Command menu = MenuFactory.getMenu(EmployeeDatabase.getInstance().getEmployeeDetails(username).getRole());
			menu.execute();
		}
		else
			Logger.error("Login with username: "+ username + " failed");
		
	}
}
