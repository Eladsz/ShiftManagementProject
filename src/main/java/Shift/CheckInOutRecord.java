//Yaniv Kaveh - Shtul : 206768004
//Elad Sztejnworcel : 204296495
package Shift;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public record CheckInOutRecord(int employeeId, LocalDate shiftDate, LocalTime startTime, LocalTime endTime) {

    public CheckInOutRecord {
        // Validation: Ensure endTime is after startTime
        if (endTime != null && endTime.isBefore(startTime)) {
            throw new IllegalArgumentException("End time cannot be before start time");
        }
    }

    public Duration duration() {
        return Duration.between(startTime, endTime);
    }
    
    public String formattedDuration() {
        Duration duration = duration();
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    @Override
    public String toString() {
        return String.format("CheckInOutRecord: employeeId=%s, shiftDate=%s, startTime=%s, endTime=%s, duration=%s",
                employeeId, shiftDate, startTime, endTime, formattedDuration());
    }
    
}

