package Menu;

import Commands.LoginMenuCommands.ForgotPasswordCommand;
import Commands.LoginMenuCommands.LoginCommand;

public class LoginMenu extends Menu {

	public LoginMenu() {
		super("Log-in Menu");
		
		LoginCommand login 						= new LoginCommand();
		ForgotPasswordCommand forgotPassword 	= new ForgotPasswordCommand();
		
		AddOption("Log-In"					, login);
		AddOption("Forgot my passowrd"		, forgotPassword);
	}
	
}
