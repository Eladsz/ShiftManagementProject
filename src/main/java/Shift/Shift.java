package Shift;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import Employee.Employee;

public class Shift {

	private static int 				shiftIDCounter = 1;
	private int 					shiftID;
	private LocalDate 				shiftDate;
	private LocalTime 				startTime;
	private LocalTime 				endTime;
	private List<CheckInOutRecord>  checkInOutRecords; 
	private Set<Employee> 			workers;
	
	
	public Shift(LocalDate shiftDate ,LocalTime startTime, LocalTime endTime) {
        // Validation: Ensure endTime is after startTime
        if (endTime.isBefore(startTime)) {
            throw new IllegalArgumentException("End time cannot be before start time");
        }
		this.setShiftDate(shiftDate);
		this.startTime = startTime;
		this.endTime = endTime;
		this.shiftID = shiftIDCounter++;
		checkInOutRecords = new ArrayList<CheckInOutRecord>();
		workers = new HashSet<Employee>();
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public int getShiftID() {
		return shiftID;
	}

	public LocalDate getShiftDate() {
		return shiftDate;
	}

	public void setShiftDate(LocalDate shiftDate) {
		this.shiftDate = shiftDate;
	}
	
	public boolean addWorker(Employee employee) {
		return workers.add(employee);
	}
	
	public boolean removeWorker(Employee employee) {
		return workers.remove(employee);
	}
	
	public List<Employee> getShiftWorkers(){
		return workers.stream().toList();
	}
	
	public boolean addCheckInOutRecord(CheckInOutRecord rec) {
		return checkInOutRecords.add(rec);
	}
	
	public boolean removeCheckInOutRecord(CheckInOutRecord rec) {
		return checkInOutRecords.remove(rec);
	}
	
	public List<CheckInOutRecord> getShiftCheckInOutRecords(){
		return checkInOutRecords;
	}
	
    public Optional<CheckInOutRecord> findRecordByEmployeeId(int employeeId) {
        return checkInOutRecords.stream()
                .filter(record -> record.employeeId() == employeeId)
                .findFirst();
    }

	@Override
	public String toString() {
		return
				  "shift id = " + shiftID + "\n"
				+ "shiftDate = " + shiftDate+ "\n"
				+ "startTime = " + startTime+ "\n"
				+ "endTime = " + endTime+ "\n\n";
	}
}
