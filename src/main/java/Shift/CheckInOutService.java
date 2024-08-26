package Shift;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import Interfaces.CheckInOutManagement;
import Logger.Logger;

public class CheckInOutService implements CheckInOutManagement {
    private final Map<Integer, CheckInOutRecord> activeRecords;
    private static CheckInOutService _instance;
    
    private CheckInOutService() {
    	activeRecords = new HashMap<>();
    }
    
    public static CheckInOutService getInstance() {
    	if (_instance == null) {
    		_instance = new CheckInOutService();
    	}
    	return _instance;
    }
    
    @Override
    public boolean checkIn(int employeeId) {
    	
    	if (ShiftsDatabase.getInstance().getCurrentShift() == null) {
    		Logger.error("There is no active shift now");
    		return false;
    	}
    	
        // Ensure there isn't already an active record for today
        if (activeRecords.containsKey(employeeId)) {
        	Logger.error("You are already checked in");
            return false; // Already checked in
        }

        // Create a new record with a placeholder endTime (null or some default)
        CheckInOutRecord record = new CheckInOutRecord(employeeId, LocalDate.now(), LocalTime.now(), null);
        activeRecords.put(employeeId, record);
        return true;
    }

    @Override
    public boolean checkOut(int employeeId) {
        CheckInOutRecord record = activeRecords.get(employeeId);

        if (record == null) {
        	Logger.error("No Active check-in");
            return false; // No active check-in
        }
        
        if(record.endTime() != null) {
        	Logger.error("Already checked out");
            return false; //already checked out
        }

        // Update the record with the check-out time
        CheckInOutRecord updatedRecord = new CheckInOutRecord(record.employeeId(), record.shiftDate(), record.startTime(), LocalTime.now());

        if(ShiftsDatabase.getInstance().getCurrentShift() != null) {
        	ShiftsDatabase.getInstance().getCurrentShift().addCheckInOutRecord(updatedRecord);
        }
        else {
        	Logger.error("There is no active shift now");
        	return false;
        }
        activeRecords.remove(record.employeeId());
        
        Logger.log(updatedRecord.toString());
        return true;
    }

    @Override
    public Optional<CheckInOutRecord> getRecord(int employeeId) {
        return Optional.ofNullable(activeRecords.get(employeeId));
    }

    @Override
    public boolean removeRecord(int employeeId) {
        return activeRecords.remove(employeeId) != null;
    }
}

