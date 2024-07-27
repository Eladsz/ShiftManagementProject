package AuthenticateSystem.Handlers;

import AuthenticationSystem.EmployeeDatabase;
import Employee.Role;
import Logger.Logger;

public class RoleCheckHandler extends Handler {

	@Override
	public boolean handle(String username, String password) {
						
        if ("admin".equals(username)) {
        	Logger.log("Loading Admin Page...");
        	return true;        	
        }
        
        renderMenu(EmployeeDatabase.getInstance().getEmployeeDetails(username).getRole());
        return handleNext(username, password);
	}
	
    private void renderMenu(Role role) {
    	Logger.log("Loading " + role.getName() + " Page...");
    }

}
