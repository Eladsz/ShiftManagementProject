//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Commands.ShiftManagementCommands;

import AuthenticationSystem.EmployeeDatabase;
import IO.Input;
import Interfaces.Command;
import Logger.Logger;
import Shift.ShiftsDatabase;

public class AssignWorkerToShiftCommand implements Command{

	@Override
	public void execute() {
		Logger.log("Please enter the shift ID");
		int shiftID = Input.getInt();
		
		if(ShiftsDatabase.getInstance().findShiftByID(shiftID) == null) {
			Logger.error("Shift ID " + shiftID + " is not found");
			return;
		}
		
		Logger.log("Please enter the worker ID");
		int workerID = Input.getInt();
		
		if (EmployeeDatabase.getInstance().findEmployee(workerID) == null) {
			Logger.error("Employee ID " + workerID + " is not found");
			return;
		}
		
		if(ShiftsDatabase.getInstance().findShiftByID(shiftID).addWorker(EmployeeDatabase.getInstance().findEmployee(workerID))) {
			
			Logger.log("Worker: \n" + EmployeeDatabase.getInstance().findEmployee(workerID).toString() + "\n"
					+ " Has been assigned to shift:\n"
					+ ShiftsDatabase.getInstance().findShiftByID(shiftID).toString() + "\n");
		}
		else
			Logger.error("Assign worker " + workerID + " to the shift " + shiftID + " - Failed");
			
	}

}
