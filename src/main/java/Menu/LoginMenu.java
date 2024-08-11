package Menu;

import Commands.LoginMenuCommands.CreateNewUserCommand;
import Commands.LoginMenuCommands.ForgotPasswordCommand;
import Commands.LoginMenuCommands.LoginCommand;

public class LoginMenu extends Menu {

	public LoginMenu() {
		super("Log-in Menu");
		
		LoginCommand login 						= new LoginCommand();
		CreateNewUserCommand createNew 			= new CreateNewUserCommand();
		ForgotPasswordCommand forgotPassword 	= new ForgotPasswordCommand();
		
		AddOption("Create New Worker Account"	, createNew);
		AddOption("Log-In"						, login);
		AddOption("Password is forgotten"		, forgotPassword);
	}
	
}
