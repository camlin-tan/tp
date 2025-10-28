package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class MedicineTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Medicine(null));
    }

    @Test
    public void constructor_invalidMedicineName_throwsIllegalArgumentException() {
        String invalidMedicineName = "";
        String invalidMedicineName2 = "   ";
        assertThrows(IllegalArgumentException.class, () -> new Medicine(invalidMedicineName));
        assertThrows(IllegalArgumentException.class, () -> new Medicine(invalidMedicineName2));
    }

    @Test
    public void isValidMedicineName() {
        // null medicine name
        assertThrows(NullPointerException.class, () -> Medicine.isValidMedicineName(null));

        // valid medicine names
        assertTrue(Medicine.isValidMedicineName("Panadol")); // alphabets only
        assertTrue(Medicine.isValidMedicineName("123")); // numbers only
        assertTrue(Medicine.isValidMedicineName("Painkiller [200mg/day]")); // alphabet, number and symbols
    }

}
