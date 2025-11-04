package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class IdentityNumberTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new IdentityNumber(null));
    }

    @Test
    public void constructor_invalidId_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new IdentityNumber(""));
        assertThrows(IllegalArgumentException.class, () -> new IdentityNumber(" "));
        assertThrows(IllegalArgumentException.class, () -> new IdentityNumber("A 123"));
        assertThrows(IllegalArgumentException.class, () -> new IdentityNumber("A@123"));
    }

    @Test
    public void isValidId() {
        // null identity number
        assertThrows(NullPointerException.class, () -> IdentityNumber.isValidId(null));

        // invalid identity number
        assertFalse(IdentityNumber.isValidId("")); // empty
        assertFalse(IdentityNumber.isValidId(" ")); // blank
        assertFalse(IdentityNumber.isValidId("A 123")); // with whitespace
        assertFalse(IdentityNumber.isValidId("A@123")); // invalid symbol
        assertFalse(IdentityNumber.isValidId("A_123")); // invalid symbol

        // valid identity number
        assertTrue(IdentityNumber.isValidId("A123")); // alphanumeric
        assertTrue(IdentityNumber.isValidId("A-123")); // with hyphen
        assertTrue(IdentityNumber.isValidId("A.123")); // with period
    }

    @Test
    public void constructor_lowerCase_storesUpperCase() {
        assertEquals("A123-B", new IdentityNumber("a123-b").identityNumber);
    }

    @Test
    public void equals_caseInsensitive_returnsTrue() {
        // Constructor converts to uppercase before comparison
        assertTrue(new IdentityNumber("a123").equals(new IdentityNumber("A123")));
    }

    @Test
    public void equals() {
        IdentityNumber identityNumber1 = new IdentityNumber("valid-identity-number-123");
        IdentityNumber identityNumber2 = new IdentityNumber("valid-identity-number-123");
        IdentityNumber identityNumber3 = new IdentityNumber("another-identity-number-123");

        // same object -> returns true
        assertTrue(identityNumber1.equals(identityNumber1));

        // same values -> returns true
        assertTrue(identityNumber1.equals(identityNumber2));

        // different values -> returns false
        assertFalse(identityNumber1.equals(identityNumber3));

        // different types -> returns false
        assertFalse(identityNumber1.equals(5));

        // null -> returns false
        assertFalse(identityNumber1.equals(null));
    }
}
