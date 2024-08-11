package Employee;

import java.time.LocalDate;

public class Employee {

	private int 			id;
	private int 			employeeID;
	private String 			firstName;
	private String 			lastName;
	private LocalDate 		birthDate;
	private Role 			role;
	private SenorityLevel 	level;
	private String 			username;
	
	public Employee(int id, String firstName, String lastName, LocalDate birthDate, Role role, SenorityLevel level, String username) {
		
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName); 
		this.setBirthDate(birthDate); 
		this.setRole(role);
		this.setLevel(level);
		this.setUsername(username);
		this.employeeID = EmployeeIDGenerator.getInstance().getID();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public SenorityLevel getLevel() {
		return level;
	}

	public void setLevel(SenorityLevel level) {
		this.level = level;
	}
	
	public int getEmployeeID() {
		return this.employeeID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return employeeID == other.employeeID || id == other.id;
				
	}
	
	@Override
	public String toString() {
		
		return "ID = " + id + "\n"
				+"Employee ID = " + employeeID + "\n"
				+ "First Name = " + firstName + "\n"
				+ "Last Name = " + lastName + "\n"
				+ "BirthDate = " + birthDate + "\n"
				+ "Role = " + role.getName() + "\n"
				+ "Level = " + level.getName() + "\n"
				+ "Username = " + username + "\n"; 
	}
	

}
