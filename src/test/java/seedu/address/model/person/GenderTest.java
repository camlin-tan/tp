package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class GenderTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Gender(null));
    }

    @Test
    public void constructor_validString_setsValueCorrectly() {
        String validDiagnoses = "Male, Female";
        Gender g = new Gender(validDiagnoses);
        assertTrue(g.gender.equals(validDiagnoses));
    }

    @Test
    public void isValidGender() {
        // valid genders
        assertTrue(Gender.isValidGender("Transgender"));
        assertTrue(Gender.isValidGender("Genderqueer"));
        assertTrue(Gender.isValidGender("Genderfluid"));

        // invalid genders
        assertFalse(Gender.isValidGender(""));
        assertFalse(Gender.isValidGender(" ")); // only whitespace
        assertFalse(Gender.isValidGender("   ")); // multiple whitespaces
    }

    @Test
    public void equals() {
        Gender g1 = new Gender("Male");
        Gender g2 = new Gender("Male");
        Gender g3 = new Gender("Female");

        // same object -> returns true
        assertTrue(g1.equals(g1));

        // same values -> returns true
        assertTrue(g1.equals(g2));

        // different values -> returns false
        assertFalse(g1.equals(g3));

        // different types -> returns false
        assertFalse(g1.equals(5));

        // null -> returns false
        assertFalse(g1.equals(null));
    }
}
