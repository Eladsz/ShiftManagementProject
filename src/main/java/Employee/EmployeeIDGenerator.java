//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Employee;

public class EmployeeIDGenerator {

	private static 	EmployeeIDGenerator _instance = null;
	private int 	id;
	
	private EmployeeIDGenerator() {
		this.id = 1;
	}
	
	public static EmployeeIDGenerator getInstance() {
		if (_instance == null) {
			_instance = new EmployeeIDGenerator();
		}
		return _instance;
	}
	
	public int getID() {
		return id++;
	}
	
	@Override
	public String toString() {
		return "Employee ID Generator [id = " + id + "]";
	}
}
