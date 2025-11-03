package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class BloodTypeTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new BloodType(null));
    }

    @Test
    public void constructor_validString_setsValueCorrectly() {
        String validBloodTypes = "AB+";
        BloodType b = new BloodType(validBloodTypes);
        assertTrue(b.bloodType.equals(validBloodTypes));
    }

    @Test
    public void isValidBloodType() {
        // valid genders
        assertTrue(BloodType.isValidBloodType("K0 (Kell-null)"));
        assertTrue(BloodType.isValidBloodType("Duffy-negative (Fy(a−b−))"));
        assertTrue(BloodType.isValidBloodType("Vel-negative"));

        // invalid genders
        assertFalse(BloodType.isValidBloodType(""));
        assertFalse(BloodType.isValidBloodType(" ")); // only whitespace
        assertFalse(BloodType.isValidBloodType("   ")); // multiple whitespaces
    }

    @Test
    public void equals() {
        BloodType b1 = new BloodType("AB+");
        BloodType b2 = new BloodType("AB+");
        BloodType b3 = new BloodType("Rh-null");

        // same object -> returns true
        assertTrue(b1.equals(b1));

        // same values -> returns true
        assertTrue(b1.equals(b2));

        // different values -> returns false
        assertFalse(b1.equals(b3));

        // different types -> returns false
        assertFalse(b1.equals(5));

        // null -> returns false
        assertFalse(b1.equals(null));
    }
}
