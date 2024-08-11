package Interfaces;

import Employee.Employee;

public interface EmployeeManagement {
	
	public boolean addEmployee(Employee employee, String password);
	public boolean removeEmployee(Employee employee);
	public Employee getEmployeeDetails(String username);
	public boolean changePassword(Employee employee ,String oldPassword, String newPassword);
	
}
