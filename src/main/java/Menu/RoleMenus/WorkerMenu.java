package Menu.RoleMenus;

import Commands.ShiftCommands.CheckInCommand;
import Commands.ShiftCommands.CheckOutCommand;
import Menu.Menu;

public class WorkerMenu extends Menu {

	public WorkerMenu(String name) {
		super(name, "Log-Out");
		CheckInCommand checkIn 		= new CheckInCommand();
		CheckOutCommand checkOut 	= new CheckOutCommand();
		AddOption("Check-in", checkIn);
		AddOption("Check-out", checkOut);
	}

}
