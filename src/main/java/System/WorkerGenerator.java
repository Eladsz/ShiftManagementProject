//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package System;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import AuthService.EmployeeDatabase;
import Employee.Employee;
import Employee.Role;
import Employee.SenorityLevel;
import Logger.Logger;
import Shift.Shift;
import Shift.ShiftsDatabase;

public class WorkerGenerator {

    private static final String[] FIRST_NAMES = {"John", "Jane", "Alex", "Emily", "Chris", "Katie"};
    private static final String[] LAST_NAMES = {"Smith", "Doe", "Johnson", "Williams", "Brown", "Davis"};
    private static final Role[] ROLES = Role.values(); // Assuming Role is an enum
    private static final SenorityLevel[] LEVELS = SenorityLevel.values(); // Assuming SenorityLevel is an enum
    private static final int MIN_9_DIGIT = 100_000_000; // Minimum 9-digit number
    private static final int MAX_9_DIGIT = 999_999_999; // Maximum 9-digit number
    
    private static Random random = new Random();

    /**
     * Generates a list of random workers, excluding the "Admin" role, and assigns them to shifts.
     *
     * @param numberOfWorkers The number of workers to generate.
     * @param shifts The list of shifts to assign workers to.
     */
    public static void generateAndAssignWorkers(int numberOfWorkers) {
        List<Employee> generatedWorkers = new ArrayList<>();
        List<Role> validRoles = new ArrayList<>();
        
        // Filter out the "Admin" role
        for (Role role : ROLES) {
            if (!role.getName().equalsIgnoreCase("Admin")) {
                validRoles.add(role);
            }
        }
        
        // Generate workers
        for (int i = 0; i < numberOfWorkers; i++) {
            String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
            String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
            LocalDate birthDate = LocalDate.of(1980 + random.nextInt(20), random.nextInt(12) + 1, random.nextInt(28) + 1);
            Role role = validRoles.get(random.nextInt(validRoles.size())); // Use filtered roles
            SenorityLevel level = LEVELS[random.nextInt(LEVELS.length)];
            String username = firstName.toLowerCase() + "." + lastName.toLowerCase() + random.nextInt(100);

            Employee worker = new Employee(generateID(), firstName, lastName, birthDate, role, level, username);
            generatedWorkers.add(worker);
            EmployeeDatabase.getInstance().addEmployee(worker, "1234");
        }

        // Distribute workers across shifts
        int shiftCount = ShiftsDatabase.getInstance().getAllShifts().size();
        int workersPerShift = numberOfWorkers / shiftCount;

        for (int i = 0; i < shiftCount; i++) {
            Shift shift = ShiftsDatabase.getInstance().getAllShifts().get(i);
            for (int j = 0; j < workersPerShift; j++) {
                // Assign workers to shift
                Employee worker = generatedWorkers.get(i * workersPerShift + j);
                shift.addWorker(worker);
            }
        }

        // If there are leftover workers (in case numberOfWorkers isn't perfectly divisible by shiftCount)
        int remainingWorkers = numberOfWorkers % shiftCount;
        for (int i = 0; i < remainingWorkers; i++) {
            Shift shift = ShiftsDatabase.getInstance().getAllShifts().get(i % shiftCount);
            Employee worker = generatedWorkers.get(numberOfWorkers - remainingWorkers + i);
            shift.addWorker(worker);
        }
        
        
        Logger.log("Workers has been generated and automatically assigned to shifts.");
    }
    
    /**
     * Generates a random 9-digit positive integer.
     * 
     * @param i Offset for generating unique IDs
     * @return A random 9-digit positive integer.
     */
    public static int generateID() {
        return MIN_9_DIGIT + random.nextInt(MAX_9_DIGIT - MIN_9_DIGIT + 1);
    }
}
