package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's smoking record in the HealthNote.
 */
public class SmokingRecord {
    public static final String DEFAULT_SMOKING_RECORD = "";
    public final String smokingRecord;

    /**
     * Constructs a {@code SmokingRecord}.
     *
     * @param record A string.
     */
    public SmokingRecord(String record) {
        requireNonNull(record);
        if (record.isEmpty()) {
            this.smokingRecord = DEFAULT_SMOKING_RECORD;
        } else {
            this.smokingRecord = record;
        }
    }

    @Override
    public String toString() {
        return smokingRecord;
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
        return smokingRecord.equalsIgnoreCase(otherRecord.smokingRecord);
    }

    @Override
    public int hashCode() {
        return smokingRecord.hashCode();
    }
}
