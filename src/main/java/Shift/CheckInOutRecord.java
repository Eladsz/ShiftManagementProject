package Shift;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public record CheckInOutRecord(int employeeId, LocalDate shiftDate, LocalTime startTime, LocalTime endTime) {

    public CheckInOutRecord {
        // Validation: Ensure endTime is after startTime
        if (endTime.isBefore(startTime)) {
            throw new IllegalArgumentException("End time cannot be before start time");
        }
    }

    // Method to calculate the duration of the shift
    public Duration duration() {
        return Duration.between(startTime, endTime);
    }

    // Optional: Override toString() for a custom string representation
    @Override
    public String toString() {
        return String.format("CheckInOutRecord[employeeId=%s, shiftDate=%s, startTime=%s, endTime=%s, duration=%s]",
                employeeId, shiftDate, startTime, endTime, duration());
    }
}

