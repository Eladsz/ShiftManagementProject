//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package AuthenticateSystem.Handlers;

import AuthService.EmployeeDatabase;
import Logger.Logger;

public class EmployeeExistsHandler extends Handler {

	@Override
	public boolean handle(String username, String password) {
		Logger.debug("EmployeeExistsHandler: ");
		if (EmployeeDatabase.getInstance().getEmployeeDetails(username) == null) {
			Logger.error("An employee with username " + username + " is not found");
			return false;
		}
		else
			return handleNext(username, password);

	}

}
