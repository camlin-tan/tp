package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class AlcoholicRecordTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AlcoholicRecord(null));
    }

    @Test
    public void constructor_invalidAlcoholicRecord_throwsIllegalArgumentException() {
        String invalidAlcoholicRecord = "";
        assertThrows(IllegalArgumentException.class, () -> new AlcoholicRecord(invalidAlcoholicRecord));

        // Starts with whitespace
        assertThrows(IllegalArgumentException.class, () -> new AlcoholicRecord(" "));
        assertThrows(IllegalArgumentException.class, () -> new AlcoholicRecord(" Never"));
    }

    @Test
    public void isValidAlcoholicRecord() {
        // null alcoholic record
        assertThrows(NullPointerException.class, () -> AlcoholicRecord.isValidAlcoholicRecord(null));

        // invalid alcoholic record
        assertFalse(AlcoholicRecord.isValidAlcoholicRecord(""));
        assertFalse(AlcoholicRecord.isValidAlcoholicRecord(" "));
        assertFalse(AlcoholicRecord.isValidAlcoholicRecord(" Non-smoker"));

        // valid alcoholic record
        assertTrue(AlcoholicRecord.isValidAlcoholicRecord("Social drinker"));
        assertTrue(AlcoholicRecord.isValidAlcoholicRecord("Yes (3 times a week)"));
    }

    @Test
    public void equals_caseInsensitive_returnsTrue() {
        assertTrue(new AlcoholicRecord("Yes").equals(new AlcoholicRecord("yes")));
        assertTrue(new AlcoholicRecord("Social").equals(new AlcoholicRecord("SOCIAL")));
    }

    @Test
    public void equals() {
        AlcoholicRecord alcoholicRecord1 = new AlcoholicRecord("valid-alcoholic record!@£$%^&*(");
        AlcoholicRecord alcoholicRecord2 = new AlcoholicRecord("valid-alcoholic record!@£$%^&*(");
        AlcoholicRecord alcoholicRecord3 = new AlcoholicRecord("another alcoholic record");

        // same object -> returns true
        assertTrue(alcoholicRecord1.equals(alcoholicRecord1));

        // same values -> returns true
        assertTrue(alcoholicRecord1.equals(alcoholicRecord2));

        // different values -> returns false
        assertFalse(alcoholicRecord3.equals(alcoholicRecord1));

        // different types -> returns false
        assertFalse(alcoholicRecord1.equals(5));

        // null -> returns false
        assertFalse(alcoholicRecord1.equals(null));
    }
}
