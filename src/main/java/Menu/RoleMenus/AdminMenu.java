package Menu.RoleMenus;

import Commands.ShiftManagementCommands.AddNewShiftCommand;
import Commands.ShiftManagementCommands.RemoveShiftCommand;
import Menu.Menu;

public class AdminMenu extends Menu {

	public AdminMenu(String name) {
		super(name, "Log-Out");
		AddNewShiftCommand addNewShift = new AddNewShiftCommand();
		RemoveShiftCommand removeShift = new RemoveShiftCommand();
		AddOption("Add New Shift", addNewShift);
		AddOption("Remove Shift", removeShift);
	}

}
