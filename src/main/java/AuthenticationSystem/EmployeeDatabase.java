//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package AuthenticationSystem;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.UserDataHandler;

import Employee.Employee;
import Employee.Role;
import Employee.SenorityLevel;
import IO.Input;
import Interfaces.EmployeeManagement;
import Logger.Logger;

public class EmployeeDatabase implements EmployeeManagement {
    private  Map<String, Employee> employeeMap;
    private static EmployeeDatabase _instance;
    
    private EmployeeDatabase() {
        employeeMap = new HashMap<>();
        addAdminUser();
    }
    
    public static EmployeeDatabase getInstance() {
    	if (_instance == null) {
    		_instance = new EmployeeDatabase();
    	}
    	return _instance;
    }

    @Override
    public boolean addEmployee(Employee employee, String password) {
    	
    
    	if (employee == null)
    		return false;
    	
    	if (employeeMap.containsKey(employee.getUsername()) || employeeMap.containsValue(employee)) 
    		return false; // User already exists
    	
    	if(UsersDatabase.getInstance().addUser(employee.getUsername(), password)) {
            employeeMap.put(employee.getUsername(), employee);
            return true; // User added successfully
    	}
    	
    	return false;


    }
    
    @Override
    public Employee getEmployeeDetails(String username) {
    	return employeeMap.get(username);
    }
    
    private void addAdminUser() {
    	employeeMap.put("admin", new Employee(0, "admin", "admin", LocalDate.now(), Role.ADMIN, SenorityLevel.EXPERT, "admin"));
    	Logger.log("Admin user has been created [username: admin, password: admin]");
    }

	@Override
	public boolean removeEmployee(Employee employee) {
		if(employeeMap.containsValue(employee)) {
			return employeeMap.remove(employee.getUsername()) != null;
		}
		return false;
	}

	@Override
	public boolean changePassword(Employee employee ,String oldPassword, String newPassword) {
		return UsersDatabase.getInstance().setPassword(employee.getUsername(), oldPassword, newPassword);
	}

	@Override
	public Employee findEmployee(int employeeID) {
		for (Employee employee: employeeMap.values()) {
			if (employee.getId() == employeeID)
				return employee;
		}
		
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeMap.values().stream().toList();
	}
	
	@Override
	public boolean changeUsername(Employee employee, String newUsername) {
		
	    if (employee == null || newUsername == null || newUsername.trim().isEmpty()) {
	        return false; // Invalid employee or new username
	    }

	    if (employeeMap.containsKey(newUsername)) {
	        return false; // New username is already taken
	    }

	    // Remove the old entry and add the new one
	    String oldUsername = employee.getUsername();
	    employeeMap.remove(oldUsername);
	    employee.setUsername(newUsername); // Assuming Employee class has a setUsername method
	    employeeMap.put(newUsername, employee);

	    // Update username in UsersDatabase as well if applicable
	    if (UsersDatabase.getInstance().updateUsername(oldUsername, newUsername)) {
	        return true; // Successfully updated username
	    } else {
	        // Rollback in case of failure to update UsersDatabase
	        employeeMap.remove(newUsername);
	        employeeMap.put(oldUsername, employee);
	        return false;
	    }
	}

	
}
