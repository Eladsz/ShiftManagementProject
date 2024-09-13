//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package AuthService;

import AuthenticateSystem.Handlers.EmployeeExistsHandler;
import AuthenticateSystem.Handlers.Handler;
import AuthenticateSystem.Handlers.RoleCheckHandler;
import AuthenticateSystem.Handlers.UserExistsHandler;
import AuthenticateSystem.Handlers.ValidPasswordHandler;
import Employee.Employee;
import Logger.Logger;

public class AuthService {
	
    private final Handler handler;
    private static AuthService _instance;
    
    private AuthService() {
    	this.handler 						 = new UserExistsHandler();
    	ValidPasswordHandler passwordHandler = new ValidPasswordHandler();
    	RoleCheckHandler roleChecker 		 = new RoleCheckHandler();
    	
    	roleChecker.setNextHandler(new EmployeeExistsHandler());
    	passwordHandler.setNextHandler(roleChecker);
    	handler.setNextHandler(passwordHandler);
    }
    
    public static AuthService getInstance() {
    	if (_instance == null) {
    		_instance = new AuthService();
    	}
    	return _instance;
    }

    public boolean logIn(String username, String password) {
        if (handler.handle(username, password)) {
            Logger.log("Authorization was successful");
            return true;
        }
        return false;
    }
    
    public boolean registerEmployee(Employee employee, String password) {
    	
    	if (UsersDatabase.getInstance().addUser(employee.getUsername(), password)) 
    		return EmployeeDatabase.getInstance().addEmployee(employee, password);	
    	
    	return false;
    }

}
