package Menu.RoleMenus;

import Commands.EmployeeManagementCommands.FindEmployeeCommand;
import Commands.EmployeeManagementCommands.PrintAllEmployeesCommand;
import Commands.ShiftCommands.PrintShiftsCommand;
import Commands.ShiftManagementCommands.AddWorkerToShiftCommand;
import Commands.ShiftManagementCommands.FindShiftCommand;
import Commands.ShiftManagementCommands.UpdateShiftCommand;

public class ShiftMangerMenu extends WorkerMenu {

	public ShiftMangerMenu(String name) {
		super(name);
		PrintShiftsCommand printShifts 				= new PrintShiftsCommand();
		UpdateShiftCommand updateShift 				= new UpdateShiftCommand();
		AddWorkerToShiftCommand addWorkerToShift 	= new AddWorkerToShiftCommand();
		FindShiftCommand findShift 					= new FindShiftCommand();
		FindEmployeeCommand findEmployee 			= new FindEmployeeCommand();
		PrintAllEmployeesCommand printAllEmployees  = new PrintAllEmployeesCommand();
		
		AddOption("Print shifts", printShifts);
		AddOption("Update shift", updateShift);
		AddOption("Find shift by ID", findShift);
		AddOption("Add worker to shift ", addWorkerToShift);
		AddOption("Find Employee by ID", findEmployee);
		AddOption("Print all employees", printAllEmployees);
	}

}
