package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PastDiagnosesTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new PastDiagnoses(null));
    }

    @Test
    public void constructor_emptyString_setsValueToNone() {
        PastDiagnoses pd = new PastDiagnoses("");
        assertTrue(pd.value.equals("None"));
    }

    @Test
    public void constructor_validString_setsValueCorrectly() {
        String validDiagnoses = "Diabetes, Hypertension";
        PastDiagnoses pd = new PastDiagnoses(validDiagnoses);
        assertTrue(pd.value.equals(validDiagnoses));
    }

    @Test
    public void isValidPastDiagnoses() {
        // valid past diagnoses
        assertTrue(PastDiagnoses.isValidPastDiagnoses("Diabetes"));
        assertTrue(PastDiagnoses.isValidPastDiagnoses("Hypertension, Asthma"));
        assertTrue(PastDiagnoses.isValidPastDiagnoses("None"));

        // empty string is valid
        assertTrue(PastDiagnoses.isValidPastDiagnoses(""));

        // invalid past diagnoses
        assertFalse(PastDiagnoses.isValidPastDiagnoses(" ")); // only whitespace
        assertFalse(PastDiagnoses.isValidPastDiagnoses("   ")); // multiple whitespaces
    }
}
