//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package AuthenticateSystem.Handlers;

import AuthenticationSystem.EmployeeDatabase;
import Employee.Role;
import Logger.Logger;

public class RoleCheckHandler extends Handler {

	@Override
	public boolean handle(String username, String password) {
		Role role;
		Logger.debug("RoleCheckHandler:");
		try {
			role = EmployeeDatabase.getInstance().getEmployeeDetails(username).getRole();
		}
		catch (Exception e) {
			Logger.error(e.getMessage());
			return false;
		}
        renderMenu(role);
        return handleNext(username, password);
	}
	
    private void renderMenu(Role role) {
    	Logger.log("Loading " + role.getName() + " Page...");
    }

}
