//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package System;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import Logger.Logger;
import Shift.Shift;
import Shift.ShiftsDatabase;

/**
 * ShiftGenerator Class
 * 
 * This class provides a method to generate a fixed set of shifts for a specified date range.
 * It generates three shifts per day with predefined start and end times.
 * 
 * The generated shifts are intended to be added to the ShiftsDatabase when the application starts.
 * 
 * The method `generateShifts` creates shifts from the `startDate` to the `endDate`, inclusive.
 * For each day in this range, it creates three shifts with the following times:
 * - Shift 1: 09:00 to 13:00
 * - Shift 2: 13:00 to 17:00
 * - Shift 3: 17:00 to 21:00
 */

public class ShiftGenerator {
	
    private static final LocalTime SHIFT_START_1 = LocalTime.of(9, 0);
    private static final LocalTime SHIFT_END_1 = LocalTime.of(13, 0);

    private static final LocalTime SHIFT_START_2 = LocalTime.of(13, 0);
    private static final LocalTime SHIFT_END_2 = LocalTime.of(17, 0);

    private static final LocalTime SHIFT_START_3 = LocalTime.of(17, 0);
    private static final LocalTime SHIFT_END_3 = LocalTime.of(21, 0);
    
    private static final LocalDate START_DATE = LocalDate.now();
    private static final LocalDate END_DATE  = START_DATE.plusWeeks(1);

    public static void generateShifts() {
        List<Shift> generatedShifts = new ArrayList<>();
        LocalDate date = START_DATE;

        while (!date.isAfter(END_DATE)) {
        	generatedShifts.add(new Shift(date, SHIFT_START_1, SHIFT_END_1));
        	generatedShifts.add(new Shift(date, SHIFT_START_2, SHIFT_END_2));
        	generatedShifts.add(new Shift(date, SHIFT_START_3, SHIFT_END_3));
            date = date.plusDays(1);
        }
        
        for (Shift shift : generatedShifts) {
        	ShiftsDatabase.getInstance().addShift(shift);
        }
        
        Logger.log("Shifts has been generated and added to the database.");

    }
}
