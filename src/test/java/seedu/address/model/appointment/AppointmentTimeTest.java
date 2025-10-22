package seedu.address.model.appointment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class AppointmentTimeTest {

    @Test
    void constructor_validFormats_success() {
        AppointmentTime t1 = new AppointmentTime("01-12-2023 14:30");
        AppointmentTime t2 = new AppointmentTime("01/12/2023 14:30");
        AppointmentTime t3 = new AppointmentTime("01.12.2023 14:30");
        assertEquals(LocalDateTime.of(2023, 12, 1, 14, 30), t1.getDateTime());
        assertEquals(LocalDateTime.of(2023, 12, 1, 14, 30), t2.getDateTime());
        assertEquals(LocalDateTime.of(2023, 12, 1, 14, 30), t3.getDateTime());
    }

    @Test
    void constructor_invalidFormat_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new AppointmentTime("2023-12-01 14:30"));
        assertThrows(IllegalArgumentException.class, () -> new AppointmentTime("01-12-2023 25:00"));
        assertThrows(IllegalArgumentException.class, () -> new AppointmentTime("01-13-2023 14:30"));
        assertThrows(IllegalArgumentException.class, () -> new AppointmentTime("01-12-2023 14:60"));
        assertThrows(IllegalArgumentException.class, () -> new AppointmentTime("01-12-2023"));
    }

    @Test
    void isValidDateTime_validAndInvalidCases() {
        assertTrue(AppointmentTime.isValidDateTime("01-12-2023 14:30"));
        assertTrue(AppointmentTime.isValidDateTime("01/12/2023 14:30"));
        assertTrue(AppointmentTime.isValidDateTime("01.12.2023 14:30"));
        assertFalse(AppointmentTime.isValidDateTime("2023-12-01 14:30"));
        assertFalse(AppointmentTime.isValidDateTime("01-12-2023 25:00"));
        assertFalse(AppointmentTime.isValidDateTime("01-12-2023 14:60"));
        assertFalse(AppointmentTime.isValidDateTime(""));
    }

    @Test
    void toString_returnsFormattedString() {
        AppointmentTime t = new AppointmentTime("02-01-2024 09:15");
        assertEquals("02-01-2024 09:15", t.toString());
    }

    @Test
    void equals_and_hashCode() {
        AppointmentTime t1 = new AppointmentTime("01-12-2023 14:30");
        AppointmentTime t2 = new AppointmentTime("01/12/2023 14:30");
        AppointmentTime t3 = new AppointmentTime("02-12-2023 14:30");
        assertEquals(t1, t2);
        assertNotEquals(t1, t3);
        assertEquals(t1.hashCode(), t2.hashCode());
    }
}

