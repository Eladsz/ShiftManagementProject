//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Interfaces;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import Employee.Employee;
import Shift.CheckInOutRecord;

public interface ShiftManagement {
	public void addNewShift(LocalDate shiftDate, LocalTime startTime,LocalTime endTime);
	public void removeShift(int shiftID);
	public List<Employee> getShiftsWorkers(int shiftID);
	public List<CheckInOutRecord> getShiftRecords(int shiftID);
	public LocalDate getShiftsDate(int shiftID);
	public LocalTime getShiftsStartTime(int shiftID);
	public LocalTime getShiftsEndTime(int shiftID);
	public boolean addWorkerToShift(int shiftID, Employee employee);
	public boolean removeWorkerFromShift(int shiftID, Employee employee);
	public boolean addCheckInOutRecord(int shiftID, CheckInOutRecord rec);
	public boolean removeCheckInOutRecord(int shiftID, CheckInOutRecord rec);
	public void printShiftsByWeek(int week,int employeeID);
	public void printShiftsByMonth(int month,int employeeID);
	public void printShiftsByDay(LocalDate date,int employeeID);
}
