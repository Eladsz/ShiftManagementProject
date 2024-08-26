package Menu.RoleMenus;

import Commands.EmployeeManagementCommands.CreateNewEmployeeCommand;
import Commands.ShiftManagementCommands.AddNewShiftCommand;
import Commands.ShiftManagementCommands.RemoveShiftCommand;

public class ManagerMenu extends ShiftMangerMenu {

	public ManagerMenu(String name) {
		super(name);
		CreateNewEmployeeCommand addNewWorker = new CreateNewEmployeeCommand();
		AddNewShiftCommand addNewShift = new AddNewShiftCommand();
		RemoveShiftCommand removeShift = new RemoveShiftCommand();
		
		AddOption("Create new worker account", addNewWorker);
		AddOption("Add New Shift", addNewShift);
		AddOption("Remove Shift", removeShift);
	}

}
