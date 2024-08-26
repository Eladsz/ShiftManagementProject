package Commands.EmployeeManagementCommands;

import AuthenticationSystem.EmployeeDatabase;
import Employee.Employee;
import IO.Input;
import Interfaces.Command;
import Logger.Logger;

public class RemoveEmployeeCommand implements Command {

	@Override
	public void execute() {
		int id = Input.getIDFromUser("Enter the employee ID");
		Employee worker = EmployeeDatabase.getInstance().findEmployee(id);
		if (worker != null) {
			if(EmployeeDatabase.getInstance().removeEmployee(worker))
				Logger.log(worker.toString() + "\nHas been removed from the database.");
			else
				Logger.error("Remove employee - Failed");
		}
		else {
			Logger.error("Employee with an ID = " + id + " is not found");
		}
		
	}

}
