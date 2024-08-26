package Commands.ShiftManagementCommands;

import java.time.LocalDate;
import java.time.LocalTime;

import IO.Input;
import Interfaces.Command;
import Shift.Shift;
import Shift.ShiftsDatabase;
import Logger.Logger;

public class UpdateShiftCommand implements Command{

	@Override
	public void execute() {
		Logger.log("Please enter the shift ID:");
		int shiftID = Input.getInt();
		boolean isValidTime = false;
		LocalTime startTime = null;
		LocalTime endTime = null;
		
		if(ShiftsDatabase.getInstance().findShiftByID(shiftID) == null) {
			Logger.error("Shift ID " + shiftID + " is not found");
			return;
		}
		LocalDate newDate = Input.getDate("Enter the updated shifts date");
		
		while(!isValidTime) {
			
			startTime = Input.getTime("Enter the updated start time");
			endTime = Input.getTime("Enter the updated end time");
			isValidTime = startTime.isBefore(endTime);
			if(!isValidTime) {
				Logger.error("Start time must be before end time - please try again");
			}
		}
		Shift tempShift = new Shift(newDate, startTime, endTime);
		
		if (ShiftsDatabase.getInstance().checkShiftConflict(tempShift, shiftID)) {
			
			Logger.error("Conflict detected with another shift. Update cannot be applied.");
			return;
		}
		
		ShiftsDatabase.getInstance().findShiftByID(shiftID).setShiftDate(newDate);
		ShiftsDatabase.getInstance().findShiftByID(shiftID).setStartTime(startTime);
		ShiftsDatabase.getInstance().findShiftByID(shiftID).setEndTime(endTime);
		
		Logger.log("Shift id = " + shiftID + " is updated");
		Logger.log(ShiftsDatabase.getInstance().findShiftByID(shiftID).toString());
	}

}
