package ShiftTests;

import org.junit.jupiter.api.Test;

import Shift.CheckInOutRecord;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CheckInOutRecordTest {

    @Test
    void testValidCheckInOutRecord() {
        int employeeId = 1;
        LocalDate shiftDate = LocalDate.of(2024, 7, 27);
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 0);

        CheckInOutRecord record = new CheckInOutRecord(employeeId, shiftDate, startTime, endTime);

        assertEquals(employeeId, record.employeeId());
        assertEquals(shiftDate, record.shiftDate());
        assertEquals(startTime, record.startTime());
        assertEquals(endTime, record.endTime());
        assertEquals(Duration.ofHours(8), record.duration());
    }

    @Test
    void testInvalidCheckInOutRecord() {
    	int employeeId = 1;
        LocalDate shiftDate = LocalDate.of(2024, 7, 27);
        LocalTime startTime = LocalTime.of(17, 0);
        LocalTime endTime = LocalTime.of(9, 0);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CheckInOutRecord(employeeId, shiftDate, startTime, endTime);
        });

        String expectedMessage = "End time cannot be before start time";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testDurationCalculation() {
    	int employeeId = 1;
        LocalDate shiftDate = LocalDate.of(2024, 7, 27);
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(12, 30);

        CheckInOutRecord record = new CheckInOutRecord(employeeId, shiftDate, startTime, endTime);

        assertEquals(Duration.ofHours(4).plusMinutes(30), record.duration());
    }
}

