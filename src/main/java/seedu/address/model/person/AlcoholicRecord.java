package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a person's alcoholic status in the HealthNote address book.
 * Stores a string value, restricted to "Yes" or "No" (case-insensitive).
 */
public class AlcoholicRecord {
    public static final String MESSAGE_CONSTRAINTS =
            "Alcoholic record cannot be null or empty.";

    public final String alcoholicRecord;

    /**
     * Constructs an {@code AlcoholicRecord}.
     *
     * @param alcoholicRecord An alcoholic record string.
     */
    public AlcoholicRecord(String alcoholicRecord) {
        requireNonNull(alcoholicRecord);
        checkArgument(isValidAlcoholicRecord(alcoholicRecord), MESSAGE_CONSTRAINTS);
        this.alcoholicRecord = alcoholicRecord;
    }

    /**
     * Returns true if a given string is a valid alcoholic record.
     */
    public static boolean isValidAlcoholicRecord(String test) {
        return test != null && !test.trim().isEmpty();
    }

    /**
     * Returns the string representation for display.
     */
    @Override
    public String toString() {
        return alcoholicRecord;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AlcoholicRecord)) {
            return false;
        }

        AlcoholicRecord otherRecord = (AlcoholicRecord) other;
        return alcoholicRecord.equalsIgnoreCase(otherRecord.alcoholicRecord);
    }

    @Override
    public int hashCode() {
        return alcoholicRecord.hashCode();
    }
}
