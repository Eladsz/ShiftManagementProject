//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Commands.EmployeeManagementCommands;

import AuthService.EmployeeDatabase;
import Employee.Employee;
import IO.Input;
import Interfaces.Command;
import Logger.Logger;

public class FindEmployeeCommand implements Command {

	@Override
	public void execute() {
		Logger.log("Enter the employee ID");
		int id = Input.getInt();
		Employee worker = EmployeeDatabase.getInstance().findEmployee(id);
		if (worker != null) {
			Logger.log(worker.toString());
		}
		else {
			Logger.error("Employee with an ID = " + id + " is not found");
		}
		
	}

}
