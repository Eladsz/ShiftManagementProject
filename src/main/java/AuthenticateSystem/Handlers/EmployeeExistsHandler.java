package AuthenticateSystem.Handlers;

import AuthenticationSystem.EmployeeDatabase;
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
