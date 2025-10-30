package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's smoking record in the HealthNote.
 */
public class SmokingRecord {
    public static final String MESSAGE_CONSTRAINTS =
            "Smoking record can be any string, and it should not be blank.";
    /*
     * The first character of the smoking record must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "^[^\\s].*";
    public static final String DEFAULT_SMOKING_RECORD = "None";
    public final String value;

    /**
     * Constructs a {@code SmokingRecord}.
     *
     * @param record A string.
     */
    public SmokingRecord(String record) {
        requireNonNull(record);
        if (record.isEmpty()) {
            this.value = DEFAULT_SMOKING_RECORD;
        } else {
            this.value = record;
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SmokingRecord)) {
            return false;
        }

        SmokingRecord otherRecord = (SmokingRecord) other;
        return value.equalsIgnoreCase(otherRecord.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
