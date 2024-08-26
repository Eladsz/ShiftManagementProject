package Menu.RoleMenus;

import Commands.EmployeeManagementCommands.FindEmployeeCommand;
import Commands.EmployeeManagementCommands.PrintAllEmployeesCommand;
import Commands.EmployeeManagementCommands.UpdateEmployeeCommand;
import Commands.ShiftCommands.PrintShiftsShiftsCommand;
import Commands.ShiftManagementCommands.AssignWorkerToShiftCommand;
import Commands.ShiftManagementCommands.FindShiftCommand;
import Commands.ShiftManagementCommands.UpdateShiftCommand;

public class ShiftMangerMenu extends WorkerMenu {

	public ShiftMangerMenu(String name) {
		super(name);
		PrintShiftsShiftsCommand printShifts 				= new PrintShiftsShiftsCommand();
		UpdateShiftCommand updateShift 				= new UpdateShiftCommand();
		AssignWorkerToShiftCommand addWorkerToShift 	= new AssignWorkerToShiftCommand();
		FindShiftCommand findShift 					= new FindShiftCommand();
		FindEmployeeCommand findEmployee 			= new FindEmployeeCommand();
		PrintAllEmployeesCommand printAllEmployees  = new PrintAllEmployeesCommand();
		UpdateEmployeeCommand updateEmployee = new UpdateEmployeeCommand();
		printShifts.printMyShifts = false;
		AddOption("Print worker's shifts", printShifts);
		AddOption("Update shift", updateShift);
		AddOption("Find shift by ID", findShift);
		AddOption("Assign worker to shift ", addWorkerToShift);
		AddOption("Find Employee by ID", findEmployee);
		AddOption("Print all employees", printAllEmployees);
		AddOption("Update Employee", updateEmployee);
	}

}
