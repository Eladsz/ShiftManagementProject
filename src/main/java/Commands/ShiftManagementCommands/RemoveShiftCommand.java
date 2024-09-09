//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Commands.ShiftManagementCommands;

import IO.Input;
import Interfaces.Command;
import Logger.Logger;
import Shift.ShiftManager;

public class RemoveShiftCommand implements Command {

	@Override
	public void execute() {
		Logger.log("Please enter the shift ID:");
		int shiftID = Input.getInt();
		ShiftManager.getInstance().removeShift(shiftID);
		
		
	}

}
