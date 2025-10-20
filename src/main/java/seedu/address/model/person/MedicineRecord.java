package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's medicineRecord in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidMedicineRecord(String)}
 */
public class MedicineRecord {

    public static final String MESSAGE_CONSTRAINTS =
            "Medicine record should not be blank or start with whitespace";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "^[^\\s].*";

    public final String medicineRecord;

    /**
     * Constructs a {@code MedicineRecord}.
     *
     * @param medicineRecord A valid medicineRecord.
     */
    public MedicineRecord(String medicineRecord) {
        requireNonNull(medicineRecord);
        checkArgument(isValidMedicineRecord(medicineRecord), MESSAGE_CONSTRAINTS);
        this.medicineRecord = medicineRecord;
    }

    /**
     * Returns true if a given string is a valid blood type.
     */
    public static boolean isValidMedicineRecord(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return medicineRecord;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof MedicineRecord)) {
            return false;
        }

        MedicineRecord otherMedicineRecord = (MedicineRecord) other;
        return medicineRecord.equals(otherMedicineRecord.medicineRecord);
    }

    @Override
    public int hashCode() {
        return medicineRecord.hashCode();
    }

}
