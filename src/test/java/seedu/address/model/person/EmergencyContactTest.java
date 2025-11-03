package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class EmergencyContactTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new EmergencyContact(null));
    }

    @Test
    public void constructor_invalidEmergencyContact_throwsIllegalArgumentException() {
        // Blank
        assertThrows(IllegalArgumentException.class, () -> new EmergencyContact(""));

        // Missing brackets for relationship
        assertThrows(IllegalArgumentException.class, () -> new EmergencyContact("mother 91234567"));

        // Missing phone number
        assertThrows(IllegalArgumentException.class, () -> new EmergencyContact("[mother]"));

        // Phone number with < 2 consecutive digits
        assertThrows(IllegalArgumentException.class, () -> new EmergencyContact("[mother] 1"));

        // Blank relationship
        assertThrows(IllegalArgumentException.class, () -> new EmergencyContact("[ ] 91234567"));
        assertThrows(IllegalArgumentException.class, () -> new EmergencyContact("[] 91234567"));
    }

    @Test
    public void isValidEmergencyContact() {
        // null
        assertThrows(NullPointerException.class, () -> EmergencyContact.isValidEmergencyContact(null));

        // invalid emergency contacts
        assertFalse(EmergencyContact.isValidEmergencyContact("")); // empty
        assertFalse(EmergencyContact.isValidEmergencyContact(" ")); // blank
        assertFalse(EmergencyContact.isValidEmergencyContact("mother 911")); // no brackets
        assertFalse(EmergencyContact.isValidEmergencyContact("[mother]")); // no phone
        assertFalse(EmergencyContact.isValidEmergencyContact("[mother] 1")); // < 2 digits for phone number
        assertFalse(EmergencyContact.isValidEmergencyContact("[ ] 911")); // blank relationship
        assertFalse(EmergencyContact.isValidEmergencyContact("[mother] 1-2-3-4")); // no 2 consecutive digits

        // valid emergency contacts
        assertTrue(EmergencyContact.isValidEmergencyContact("[mother] 91234567"));
        assertTrue(EmergencyContact.isValidEmergencyContact("[Father (Home)] +65 1234 5678"));
        assertTrue(EmergencyContact.isValidEmergencyContact("[Sister] 999 (office)"));
        assertTrue(EmergencyContact.isValidEmergencyContact("[Friend] 12-34-56"));
    }

    @Test
    public void constructor_parsesCorrectly() {
        String input = "[Mother] 123456 (Home)";
        EmergencyContact contact = new EmergencyContact(input);

        assertEquals("Mother", contact.relationship);
        assertEquals("123456 (Home)", contact.phone.value);
    }

    @Test
    public void toString_formatsCorrectly() {
        EmergencyContact contact = new EmergencyContact("[Mother] 123456");
        assertEquals("[Mother] 123456", contact.toString());
    }

    @Test
    public void equals() {
        EmergencyContact emergencyContact = new EmergencyContact("[Mother] 123456");

        // same values -> returns true
        assertTrue(emergencyContact.equals(new EmergencyContact("[Mother] 123456")));

        // same object -> returns true
        assertTrue(emergencyContact.equals(emergencyContact));

        // null -> returns false
        assertFalse(emergencyContact.equals(null));

        // different types -> returns false
        assertFalse(emergencyContact.equals(5.0f));

        // different relationship -> returns false
        assertFalse(emergencyContact.equals(new EmergencyContact("[Father] 123456")));

        // different phone -> returns false
        assertFalse(emergencyContact.equals(new EmergencyContact("[Mother] 654321")));
    }
}
