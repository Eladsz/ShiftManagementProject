//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package DatabaseTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AuthenticationSystem.EmployeeDatabase;
import Employee.Employee;
import Employee.Role;
import Employee.SenorityLevel;

public class EmployeeDatabaseTest {
    private EmployeeDatabase database;
    private Employee employee1;

    @BeforeEach
    void setUp() {
        database = EmployeeDatabase.getInstance();
        employee1 = new Employee(1, "John", "Doe", LocalDate.of(1985, 5, 15), Role.WORKER, SenorityLevel.JUNIOR, "johndoe");
    }

    @Test
    void testAddEmployee() {
        assertTrue(database.addEmployee(employee1, "password"));
        assertEquals(employee1, database.getEmployeeDetails("johndoe"));

        // Adding the same employee again should return false
        assertFalse(database.addEmployee(employee1, "password"));

    }

    @Test
    void testAddEmployeeNull() {
        assertFalse(database.addEmployee(null, null));
    }

    @Test
    void testGetEmployeeDetails() {
        database.addEmployee(employee1, "password");
        assertEquals(employee1, database.getEmployeeDetails("johndoe"));

        // Non-existent employee should return null
        assertNull(database.getEmployeeDetails("nonexistent"));
    }
}
