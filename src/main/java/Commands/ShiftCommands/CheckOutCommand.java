//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Commands.ShiftCommands;

import java.time.LocalTime;

import Commands.LoginMenuCommands.LoginCommand;
import Interfaces.Command;
import Logger.Logger;
import Shift.CheckInOutService;
import Shift.ShiftsDatabase;

public class CheckOutCommand implements Command {

	@Override
	public void execute() {
		if(CheckInOutService.getInstance().checkOut(LoginCommand.loggedIn.getEmployeeID())) {
			Logger.log(LoginCommand.loggedIn.getFirstName() + " check-out time: " + LocalTime.now());
			Logger.log("Current shift: \n" + ShiftsDatabase.getInstance().getCurrentShift().toString());
		}
		
	}

}
