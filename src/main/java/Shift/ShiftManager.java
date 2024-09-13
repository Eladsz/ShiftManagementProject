//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Shift;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import AuthService.EmployeeDatabase;
import Employee.Employee;
import IO.Input;
import Interfaces.ShiftManagement;
import Logger.Logger;

public class ShiftManager implements ShiftManagement {

	private static ShiftManager _instance;
	
	private ShiftManager() {
	
	}
	
	public static ShiftManager getInstance() {
		if (_instance == null) {
			_instance = new ShiftManager();
		}
		return _instance;
	}
	
	@Override
	public void addNewShift(LocalDate shiftDate, LocalTime startTime,LocalTime endTime) {
		
			Shift newShift;
			
			try {
				newShift = new Shift(shiftDate, startTime, endTime);
				if (ShiftsDatabase.getInstance().addShift(newShift)) {
					Logger.log("Shift \n" + newShift.toString() + "has been added successfully");
					return;
				}
				else {
					Logger.error("Conflict detected with another shift. Add new shift - Failed");
					Logger.error("Please try again");
				}
				
					
			}
			catch (Exception e) {
				Logger.error(e.getMessage());
				Logger.error("Please try again");
			}

	}

	@Override
	public void removeShift(int shiftID) {

		Shift shift = ShiftsDatabase.getInstance().findShiftByID(shiftID);
		if (shift == null)
			Logger.error("Shift ID " + shiftID + " is not found");
		else {
			if(ShiftsDatabase.getInstance().removeShift(shift))
				Logger.log("Remove shift " + shift.toString() + " Done successfully");
			else
				Logger.error("Remove shift " + shift.toString() + " Failed");
		}
				
	}

	@Override
	public List<Employee> getShiftsWorkers(int shiftID) {
		
		Shift shift = ShiftsDatabase.getInstance().findShiftByID(shiftID);
		
		if (shift == null) {
			Logger.error("Shift ID " + shiftID + " is not found");
			return null;
		}
		
		return shift.getShiftWorkers();

	}

	@Override
	public List<CheckInOutRecord> getShiftRecords(int shiftID) {
		
		Shift shift = ShiftsDatabase.getInstance().findShiftByID(shiftID);
		
		if (shift == null) {
			Logger.error("Shift ID " + shiftID + " is not found");
			return null;
		}
		
		return shift.getShiftCheckInOutRecords();
	}

	@Override
	public LocalDate getShiftsDate(int shiftID) {
		Shift shift = ShiftsDatabase.getInstance().findShiftByID(shiftID);
		
		if (shift == null) {
			Logger.error("Shift ID " + shiftID + " is not found");
			return null;
		}
		
		return shift.getShiftDate();
	}

	@Override
	public LocalTime getShiftsStartTime(int shiftID) {
		Shift shift = ShiftsDatabase.getInstance().findShiftByID(shiftID);
		
		if (shift == null) {
			Logger.error("Shift ID " + shiftID + " is not found");
			return null;
		}
		
		return shift.getStartTime();
	}

	@Override
	public LocalTime getShiftsEndTime(int shiftID) {
		Shift shift = ShiftsDatabase.getInstance().findShiftByID(shiftID);
		
		if (shift == null) {
			Logger.error("Shift ID " + shiftID + " is not found");
			return null;
		}
		
		return shift.getEndTime();
	}

	@Override
	public boolean addWorkerToShift(int shiftID, Employee employee) {
		Shift shift = ShiftsDatabase.getInstance().findShiftByID(shiftID);
		
		if (shift == null) {
			Logger.error("Shift ID " + shiftID + " is not found");
			return false;
		}
		
		return shift.addWorker(employee);
	}

	@Override
	public boolean removeWorkerFromShift(int shiftID, Employee employee) {
		Shift shift = ShiftsDatabase.getInstance().findShiftByID(shiftID);
		
		if (shift == null) {
			Logger.error("Shift ID " + shiftID + " is not found");
			return false;
		}
		
		return shift.removeWorker(employee);
	}

	@Override
	public boolean addCheckInOutRecord(int shiftID, CheckInOutRecord rec) {
		Shift shift = ShiftsDatabase.getInstance().findShiftByID(shiftID);
		
		if (shift == null) {
			Logger.error("Shift ID " + shiftID + " is not found");
			return false;
		}
		
		return shift.addCheckInOutRecord(rec);
	}

	@Override
	public boolean removeCheckInOutRecord(int shiftID, CheckInOutRecord rec) {
		Shift shift = ShiftsDatabase.getInstance().findShiftByID(shiftID);
		
		if (shift == null) {
			Logger.error("Shift ID " + shiftID + " is not found");
			return false;
		}
		
		return shift.removeCheckInOutRecord(rec);
	}

	@Override
	public void printShiftsByWeek(int week, int employeeID) {
		List<Shift> shifts = ShiftsDatabase.getInstance().getShiftsByWeek(week);
		if (shifts.isEmpty()) {
			Logger.error("There is no shifts on week number " + week);
			return;
		}
		
		Logger.log("Shifts on week " + week + " for employee ID = " + employeeID +":");
		printShifts(shifts, EmployeeDatabase.getInstance().findEmployee(employeeID));
		
	}

	@Override
	public void printShiftsByMonth(int month,int employeeID) {
		List<Shift> shifts = ShiftsDatabase.getInstance().getShiftsByMonth(month);
		if (shifts.isEmpty()) {
			Logger.error("There is no shifts on month number " + month);
			return;
		}
		
		Logger.log("Shifts on month " + month +" for employee ID = " + employeeID + ":");
		printShifts(shifts,EmployeeDatabase.getInstance().findEmployee(employeeID));
		
	}

	@Override
	public void printShiftsByDay(LocalDate date, int employeeID) {
		List<Shift> shifts = ShiftsDatabase.getInstance().getShiftsByDate(date);
		if (shifts.isEmpty()) {
			Logger.error("There is no shifts on date " + date);
			return;
		}
		
		Logger.log("Shifts on date " + date +" for employee ID = " + employeeID + ":");
		printShifts(shifts, EmployeeDatabase.getInstance().findEmployee(employeeID));
		
	}
	
	private void printShifts(List<Shift> shifts, Employee employee) {
		if (employee == null) {
			Logger.error("Employee is not found");
			return;
		}
		shifts = shifts.stream().filter(s -> s.getShiftWorkers().contains(employee)).collect(Collectors.toList());
		if (shifts.isEmpty())
			Logger.log("There are no shifts for employee ID = " + employee.getId());
		
		for (Shift shift : shifts){
			Logger.log(shift.toString());
		}
	}
	
	


}
