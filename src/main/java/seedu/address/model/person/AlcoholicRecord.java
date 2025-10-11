package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a person's alcoholic status in the HealthNote address book.
 * Stores a string value, restricted to "Yes" or "No" (case-insensitive).
 */
public class AlcoholicRecord {
    public static final String MESSAGE_CONSTRAINTS =
            "Alcoholic record should be 'Yes' or 'No'.";

    /**
     * The regular expression used to validate the alcoholic record.
     * Ensures the input is exactly "Yes" or "No" (case-insensitive) and does not allow
     * blank strings or strings starting with whitespace.
     */
    private static final String VALIDATION_REGEX = "^(?i)(Yes|No)$";

    public final String alcoholicRecord;

    /**
     * Constructs an {@code AlcoholicRecord}.
     *
     * @param alcoholicRecord A valid alcoholic record ("Yes" or "No").
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
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns the string representation ("Yes" or "No") for display.
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
