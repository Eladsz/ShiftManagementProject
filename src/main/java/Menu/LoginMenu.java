package Menu;

import Commands.CreateNewUserCommand;
import Commands.LoginCommand;

public class LoginMenu extends Menu {

	public LoginMenu() {
		super("Log-in Menu");
		LoginCommand login = new LoginCommand();
		CreateNewUserCommand createNew = new CreateNewUserCommand();
		AddOption("Create New Worker Account", createNew);
		AddOption("Log-In", login);
	}
	
}
