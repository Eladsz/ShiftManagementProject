//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Commands.EmployeeManagementCommands;

import AuthenticationSystem.EmployeeDatabase;
import AuthenticationSystem.UsersDatabase;
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
			if(EmployeeDatabase.getInstance().removeEmployee(worker) && UsersDatabase.getInstance().removeUser(worker.getUsername()))
				Logger.log(worker.toString() + "\nHas been removed from the database.");
			else
				Logger.error("Remove employee - Failed");
		}
		else {
			Logger.error("Employee with an ID = " + id + " is not found");
		}
		
	}

}
