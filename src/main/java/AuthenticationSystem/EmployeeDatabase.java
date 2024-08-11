package AuthenticationSystem;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.UserDataHandler;

import Employee.Employee;
import Employee.Role;
import Employee.SenorityLevel;
import IO.Input;
import Interfaces.EmployeeManagement;

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
    
}
