//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Interfaces;

import java.util.Optional;

import Shift.CheckInOutRecord;

public interface CheckInOutManagement {
	 public boolean checkIn(int employeeId);
	 public boolean checkOut(int employeeId);
	 public Optional<CheckInOutRecord> getRecord(int employeeId);
	 public boolean removeRecord(int employeeId);
}
