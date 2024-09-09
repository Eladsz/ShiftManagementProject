//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Shift;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ShiftsDatabase {
	
	private static ShiftsDatabase _instance;
	private List<Shift> shifts;
	
	private ShiftsDatabase() {
		shifts = new ArrayList<Shift>();
	}
	
	public static ShiftsDatabase getInstance() {
		if (_instance == null)
			_instance = new ShiftsDatabase();
		return _instance;
	}
	
	public List<Shift> getAllShifts(){
		return shifts;
	}
	
	public boolean addShift(Shift newShift) {

		if(checkShiftConflict(newShift, 0))
			return false;
		
		return shifts.add(newShift);
	}
	
	public boolean removeShift(Shift shift) {
		return shifts.remove(shift);
	}
	
	public Shift findShiftByID(int shiftID) {
		for (Shift shift : shifts) {
			if (shift.getShiftID() == shiftID)
				return shift;
		}
		return null;
	}
	
	public List<Shift> getShiftsByDate(LocalDate date){
		List<Shift> shiftsByDay = new ArrayList<Shift>();
		for (Shift shift : shifts) {
			if (shift.getShiftDate().equals(date))
				shiftsByDay.add(shift);
		}
		return shiftsByDay;
	}
	
	public List<Shift> getShiftsByWeek(int week){
		List<Shift> shiftsByWeek = new ArrayList<Shift>();
		WeekFields weekFields = WeekFields.of(Locale.getDefault());
		
		for (Shift shift : shifts) {
			if (shift.getShiftDate().get(weekFields.weekOfYear()) == week)
				shiftsByWeek.add(shift);
		}
		return shiftsByWeek;
	}
	
	public List<Shift> getShiftsByMonth(int month){
		List<Shift> shiftsByMonth = new ArrayList<Shift>();

		for (Shift shift : shifts) {
			if (shift.getShiftDate().getMonthValue() == month)
				shiftsByMonth.add(shift);
		}
		return shiftsByMonth;
	}
	
    public Shift getCurrentShift() {
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate();
        LocalTime currentTime = now.toLocalTime();
        
        for (Shift shift : shifts) {
            LocalDate shiftDate = shift.getShiftDate();
            LocalTime shiftStartTime = shift.getStartTime();
            LocalTime shiftEndTime = shift.getEndTime();
            
            // Check if the shift date is today and current time is within shift hours
            if (shiftDate.equals(today) && !currentTime.isBefore(shiftStartTime) && !currentTime.isAfter(shiftEndTime)) {
                return shift;
            }
        }
        return null; // No shift found for the current time
    }

    public boolean checkShiftConflict(Shift newShift, int skipID) {
		for (Shift shift: shifts) {
			if (shift.getShiftDate().equals(newShift.getShiftDate())) {
				
				if (newShift.getStartTime().isBefore(shift.getEndTime()) && newShift.getEndTime().isAfter(shift.getStartTime()))
					return true;
				}
			}
		
		return false;
    }
}

