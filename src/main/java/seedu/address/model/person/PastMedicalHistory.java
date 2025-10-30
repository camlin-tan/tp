package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a person's past medical history in the HealthNote.
 */
public class PastMedicalHistory {
    public static final String MESSAGE_CONSTRAINTS =
            "Past medical history can be any string, and it should not be blank.";

    public static final String VALIDATION_REGEX = "[^\\s].*";

    public static final String DEFAULT_PAST_MEDICAL_HISTORY = "None";
    public final String value;

    /**
     * Constructs a {@code PastMedicalHistory}.
     *
     * @param medicalHistory A string representing the past medical history. Can be empty.
     */
    public PastMedicalHistory(String medicalHistory) {
        requireNonNull(medicalHistory);
        if (medicalHistory.isEmpty()) {
            this.value = DEFAULT_PAST_MEDICAL_HISTORY;
        } else {
            this.value = medicalHistory;
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
        if (!(other instanceof PastMedicalHistory)) {
            return false;
        }

        PastMedicalHistory otherMedicalHistory = (PastMedicalHistory) other;
        return value.equals(otherMedicalHistory.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
