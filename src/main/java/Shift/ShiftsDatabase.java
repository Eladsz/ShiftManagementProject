package Shift;

import java.time.LocalDate;
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
	
	public boolean addShift(Shift newShift) {
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

}
