package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's Identity Number in the system.
 * Guarantees: immutable; is valid as declared in {@link #isValidId(String)}
 */
public class IdentityNumber {

    public static final String MESSAGE_CONSTRAINTS =
            "ID should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String id;

    /**
     * Constructs an {@code Identity number}.
     *
     * @param id A valid id.
     */
    public IdentityNumber(String id) {
        requireNonNull(id);
        checkArgument(isValidId(id), MESSAGE_CONSTRAINTS);
        this.id = id;
    }

    /**
     * Returns true if a given string is a valid identity number.
     */
    public static boolean isValidId(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof IdentityNumber)) {
            return false;
        }

        IdentityNumber otherId = (IdentityNumber) other;
        return id.equals(otherId.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
