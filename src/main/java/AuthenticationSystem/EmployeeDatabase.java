package AuthenticationSystem;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.UserDataHandler;

import Employee.Employee;
import IO.Input;

public class EmployeeDatabase {
    private  Map<String, Employee> employeeMap;
    private static EmployeeDatabase _instance;
    
    private EmployeeDatabase() {
        employeeMap = new HashMap<>();
    }
    
    public static EmployeeDatabase getInstance() {
    	if (_instance == null) {
    		_instance = new EmployeeDatabase();
    	}
    	return _instance;
    }

    public boolean addEmployee(Employee employee) {
    	
    
    	if (employee == null)
    		return false;
    	
    	if (employeeMap.containsKey(employee.getUsername()) || employeeMap.containsValue(employee)) 
    		return false; // User already exists
    	
    	if(UsersDatabase.getInstance().addUser(employee.getUsername(), Input.getString("Passowrd"))) {
            employeeMap.put(employee.getUsername(), employee);
            return true; // User added successfully
    	}
    	
    	return false;


    }
    
    public Employee getEmployeeDetails(String username) {
    	return employeeMap.get(username);
    }
    
    
}
