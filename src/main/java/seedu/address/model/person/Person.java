package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final IdentityNumber identityNumber;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Address address;
    private final Set<Tag> tags = new HashSet<>();
    private final BloodType bloodType;
    private final DateOfBirth dateOfBirth;
    private final AlcoholicRecord alcoholicRecord;
    private final Gender gender;


    /**
     * Every field must be present and not null.
     */
    public Person(Name name, IdentityNumber identityNumber, Phone phone, Email email, Address address, Set<Tag> tags,
                  DateOfBirth dateOfBirth, BloodType bloodType, AlcoholicRecord alcoholicRecord, Gender gender) {
        requireAllNonNull(name, identityNumber, phone, email, address, tags, dateOfBirth, bloodType,
                alcoholicRecord, gender);
        this.name = name;
        this.identityNumber = identityNumber;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
        this.dateOfBirth = dateOfBirth;
        this.bloodType = bloodType;
        this.alcoholicRecord = alcoholicRecord;
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public IdentityNumber getIdentityNumber() {
        return identityNumber;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public AlcoholicRecord getAlcoholicRecord() {
        return alcoholicRecord;
    }

    public Gender getGender() {
        return gender;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons have the same identity number.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getIdentityNumber().equals(getIdentityNumber());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return name.equals(otherPerson.name)
                && identityNumber.equals(otherPerson.identityNumber)
                && phone.equals(otherPerson.phone)
                && email.equals(otherPerson.email)
                && address.equals(otherPerson.address)
                && tags.equals(otherPerson.tags)
                && dateOfBirth.equals(otherPerson.dateOfBirth)
                && bloodType.equals(otherPerson.bloodType)
                && alcoholicRecord.equals(otherPerson.alcoholicRecord)
                && gender.equals(otherPerson.gender);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, identityNumber, phone, email, address, tags,
                dateOfBirth, bloodType, alcoholicRecord, gender);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("identityNumber", identityNumber)
                .add("phone", phone)
                .add("email", email)
                .add("address", address)
                .add("tags", tags)
                .add("dateOfBirth", dateOfBirth)
                .add("bloodType", bloodType)
                .add("alcoholicRecord", alcoholicRecord)
                .add("gender", gender)
                .toString();
    }

}
