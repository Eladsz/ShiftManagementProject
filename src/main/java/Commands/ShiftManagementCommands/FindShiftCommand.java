//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Commands.ShiftManagementCommands;

import Employee.Employee;
import IO.Input;
import Interfaces.Command;
import Logger.Logger;
import Shift.CheckInOutRecord;
import Shift.ShiftsDatabase;

public class FindShiftCommand implements Command{

	@Override
	public void execute() {
		Logger.log("Please enter the shift ID");
		int shiftID = Input.getInt();
		
		if(ShiftsDatabase.getInstance().findShiftByID(shiftID) == null) {
			Logger.error("Shift ID " + shiftID + " is not found");
			return;
		}
		
		Logger.log(ShiftsDatabase.getInstance().findShiftByID(shiftID).toString());
		int i = 1;
		Logger.log("Workers:");
		for (Employee worker : ShiftsDatabase.getInstance().findShiftByID(shiftID).getShiftWorkers()) {
			Logger.log(i++ + ". id = " + worker.getId() + " "+ worker.getFirstName() + " " + worker.getLastName() + " " + worker.getLevel().getName() + " " + worker.getRole().getName());
		}
		
		Logger.log("Check-In/Out records:");
		for (CheckInOutRecord rec : ShiftsDatabase.getInstance().findShiftByID(shiftID).getShiftCheckInOutRecords()) {
			Logger.log(rec.toString());
		}
	}

}
