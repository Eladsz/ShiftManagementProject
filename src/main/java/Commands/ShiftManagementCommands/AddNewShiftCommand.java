package Commands.ShiftManagementCommands;

import java.time.LocalDate;
import java.time.LocalTime;

import IO.Input;
import Interfaces.Command;
import Shift.ShiftManager;

public class AddNewShiftCommand implements Command {

	@Override
	public void execute() {
		LocalDate shiftDate = Input.getDate("Shift date");
		LocalTime startTime = Input.getTime("Shift Start time");
		LocalTime endTime 	= Input.getTime("Shift End time");
		ShiftManager manager = new ShiftManager();
		
		manager.addNewShift(shiftDate, startTime, endTime);
	}

}
