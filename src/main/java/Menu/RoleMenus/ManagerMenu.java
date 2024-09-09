//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Menu.RoleMenus;

import Commands.EmployeeManagementCommands.CreateNewEmployeeCommand;
import Commands.EmployeeManagementCommands.RemoveEmployeeCommand;
import Commands.ShiftManagementCommands.AddNewShiftCommand;
import Commands.ShiftManagementCommands.RemoveShiftCommand;

public class ManagerMenu extends ShiftMangerMenu {

	public ManagerMenu(String name) {
		super(name);
		CreateNewEmployeeCommand addNewWorker = new CreateNewEmployeeCommand();
		AddNewShiftCommand addNewShift = new AddNewShiftCommand();
		RemoveShiftCommand removeShift = new RemoveShiftCommand();
		RemoveEmployeeCommand removeEmployee = new RemoveEmployeeCommand();
		
		AddOption("Create new worker account", addNewWorker);
		AddOption("Remove worker", removeEmployee);
		AddOption("Add New Shift", addNewShift);
		AddOption("Remove Shift", removeShift);
	}

}
