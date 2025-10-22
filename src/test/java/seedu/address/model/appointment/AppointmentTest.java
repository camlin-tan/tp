package seedu.address.model.appointment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;

import org.junit.jupiter.api.Test;

class AppointmentTest {

    @Test
    void constructor_and_getters() {
        AppointmentNotes notes = new AppointmentNotes("Test notes");
        AppointmentTime time = new AppointmentTime("01-12-2023 14:30");
        Appointment appointment = new Appointment(notes, time, ALICE);
        assertEquals(notes, appointment.getNotes());
        assertEquals(time, appointment.getDateTime());
        assertEquals(ALICE, appointment.getPatient());
    }

    @Test
    void equals_and_hashCode() {
        AppointmentNotes notes1 = new AppointmentNotes("Test notes");
        AppointmentNotes notes2 = new AppointmentNotes("Test notes");
        AppointmentNotes notes3 = new AppointmentNotes("Other notes");
        AppointmentTime time = new AppointmentTime("01-12-2023 14:30");
        Appointment a1 = new Appointment(notes1, time, ALICE);
        Appointment a2 = new Appointment(notes2, time, ALICE);
        Appointment a3 = new Appointment(notes3, time, ALICE);
        assertEquals(a1, a2);
        assertNotEquals(a1, a3);
        assertEquals(a1.hashCode(), a2.hashCode());
    }

    @Test
    void isSameAppointment_trueAndFalseCases() {
        AppointmentNotes notes1 = new AppointmentNotes("Test notes");
        AppointmentNotes notes2 = new AppointmentNotes("Other notes");
        AppointmentTime time = new AppointmentTime("01-12-2023 14:30");
        Appointment a1 = new Appointment(notes1, time, ALICE);
        Appointment a2 = new Appointment(notes2, time, ALICE);
        Appointment a3 = new Appointment(notes1, new AppointmentTime("02-12-2023 14:30"), ALICE);
        Appointment a4 = new Appointment(notes1, time, BOB);

        assertTrue(a1.isSameAppointment(a2));
        assertFalse(a1.isSameAppointment(a3));
        assertFalse(a1.isSameAppointment(a4));
        assertTrue(a1.isSameAppointment(a1));
        assertFalse(a1.isSameAppointment(null));
    }

    @Test
    void toString_containsAllFields() {
        AppointmentNotes notes = new AppointmentNotes("Test notes");
        AppointmentTime time = new AppointmentTime("01-12-2023 14:30");
        Appointment appointment = new Appointment(notes, time, ALICE);
        String result = appointment.toString();
        assertTrue(result.contains("01-12-2023 14:30"));
        assertTrue(result.contains("Alice"));
        assertTrue(result.contains("Test notes"));
    }
}

