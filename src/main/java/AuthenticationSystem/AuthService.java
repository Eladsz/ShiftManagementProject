package AuthenticationSystem;

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
        this.handler = 			new UserExistsHandler()
        		.setNextHandler(new ValidPasswordHandler())
        		.setNextHandler(new EmployeeExistsHandler())
        		.setNextHandler(new RoleCheckHandler());
    }
    
    public static AuthService getInstance() {
    	if (_instance == null) {
    		_instance = new AuthService();
    	}
    	return _instance;
    }

    public boolean logIn(String email, String password) {
        if (handler.handle(email, password)) {
            Logger.log("Authorization was successful!");
            return true;
        }
        return false;
    }
    
    public boolean registerEmployee(Employee employee, String password) {
    	
    	if (UsersDatabase.getInstance().addUser(employee.getUsername(), password)) 
    		return EmployeeDatabase.getInstance().addEmployee(employee);	
    	
    	return false;
    }

}
