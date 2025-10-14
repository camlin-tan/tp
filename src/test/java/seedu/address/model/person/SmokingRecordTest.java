package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class SmokingRecordTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new SmokingRecord(null));
    }

    @Test
    public void constructor_invalidSmokingRecord_throwsIllegalArgumentException() {
        String invalidRecord = "maybe";
        assertThrows(IllegalArgumentException.class, () -> new SmokingRecord(invalidRecord));
    }

    @Test
    public void isValidSmokingRecord() {
        // null smoking record
        assertThrows(NullPointerException.class, () -> SmokingRecord.isValidSmokingRecord(null));

        // invalid smoking records
        assertFalse(SmokingRecord.isValidSmokingRecord("")); // empty string
        assertFalse(SmokingRecord.isValidSmokingRecord(" ")); // spaces only
        assertFalse(SmokingRecord.isValidSmokingRecord("yess")); // incorrect spelling
        assertFalse(SmokingRecord.isValidSmokingRecord("noo")); // incorrect spelling
        assertFalse(SmokingRecord.isValidSmokingRecord("y es")); // space in between

        // valid smoking records
        assertTrue(SmokingRecord.isValidSmokingRecord("yes"));
        assertTrue(SmokingRecord.isValidSmokingRecord("no"));
        assertTrue(SmokingRecord.isValidSmokingRecord("YES")); // case-insensitive
        assertTrue(SmokingRecord.isValidSmokingRecord("No")); // case-insensitive
        assertTrue(SmokingRecord.isValidSmokingRecord("  yes  ")); // with leading/trailing spaces
    }

    @Test
    public void equals() {
        SmokingRecord smokingRecord = new SmokingRecord("yes");

        // same values -> returns true
        assertTrue(smokingRecord.equals(new SmokingRecord("yes")));

        // same object -> returns true
        assertTrue(smokingRecord.equals(smokingRecord));

        // null -> returns false
        assertFalse(smokingRecord.equals(null));

        // different types -> returns false
        assertFalse(smokingRecord.equals(5.0f));

        // different values -> returns false
        assertFalse(smokingRecord.equals(new SmokingRecord("no")));
    }
}
