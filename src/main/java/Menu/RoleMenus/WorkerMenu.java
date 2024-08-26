package Menu.RoleMenus;

import Commands.ShiftCommands.CheckInCommand;
import Commands.ShiftCommands.CheckOutCommand;
import Commands.ShiftCommands.PrintShiftsShiftsCommand;
import Menu.Menu;

public class WorkerMenu extends Menu {

	public WorkerMenu(String name) {
		super(name, "Log-Out");
		CheckInCommand checkIn 		= new CheckInCommand();
		CheckOutCommand checkOut 	= new CheckOutCommand();
		PrintShiftsShiftsCommand printMyShifts = new PrintShiftsShiftsCommand();
		
		AddOption("Check-in", checkIn);
		AddOption("Check-out", checkOut);
		AddOption("Print my shifts", printMyShifts);
	}

}
