package Commands.EmployeeManagementCommands;

import AuthenticationSystem.EmployeeDatabase;
import Employee.Employee;
import Interfaces.Command;
import Logger.Logger;

public class PrintAllEmployeesCommand implements Command {

	@Override
	public void execute() {
		int i = 1;
		for (Employee w : EmployeeDatabase.getInstance().getAllEmployees()) {
			Logger.log(i++ +". " +  w.toString());
		}
		
	}

}
