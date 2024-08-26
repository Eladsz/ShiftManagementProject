package Commands.ShiftCommands;

import java.time.LocalTime;

import Commands.LoginMenuCommands.LoginCommand;
import Interfaces.Command;
import Logger.Logger;
import Shift.CheckInOutService;
import Shift.ShiftsDatabase;

public class CheckInCommand implements Command {

	@Override
	public void execute() {
		if(CheckInOutService.getInstance().checkIn(LoginCommand.loggedIn.getEmployeeID())) {
			Logger.log(LoginCommand.loggedIn.getFirstName() + " check-in time: " + LocalTime.now());
			Logger.log("Current shift: \n" + ShiftsDatabase.getInstance().getCurrentShift().toString());
		}
		
	}

}
