package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.AlcoholicRecord;
import seedu.address.model.person.BloodType;
import seedu.address.model.person.DateOfBirth;
import seedu.address.model.person.Email;
import seedu.address.model.person.Gender;
import seedu.address.model.person.IdentityNumber;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.SmokingRecord;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_ID = "A60";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_BLOOD_TYPE = "O";
    public static final String DEFAULT_DOB = "01-01-2000";
    public static final String DEFAULT_ALCOHOLIC_RECORD = "No";
    public static final String DEFAULT_GENDER = "F";
    public static final String DEFAULT_SMOKING_RECORD = "no";

    private Name name;
    private IdentityNumber identityNumber;
    private Phone phone;
    private Email email;
    private Address address;
    private Set<Tag> tags;
    private BloodType bloodType;
    private DateOfBirth dateOfBirth;
    private AlcoholicRecord alcoholicRecord;
    private Gender gender;
    private SmokingRecord smokingRecord;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        identityNumber = new IdentityNumber(DEFAULT_ID);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();
        bloodType = new BloodType(DEFAULT_BLOOD_TYPE);
        dateOfBirth = new DateOfBirth(DEFAULT_DOB);
        alcoholicRecord = new AlcoholicRecord(DEFAULT_ALCOHOLIC_RECORD);
        gender = new Gender(DEFAULT_GENDER);
        smokingRecord = new SmokingRecord(DEFAULT_SMOKING_RECORD);
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        identityNumber = personToCopy.getIdentityNumber();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        address = personToCopy.getAddress();
        tags = new HashSet<>(personToCopy.getTags());
        bloodType = personToCopy.getBloodType();
        dateOfBirth = personToCopy.getDateOfBirth();
        alcoholicRecord = personToCopy.getAlcoholicRecord();
        gender = personToCopy.getGender();
        smokingRecord = personToCopy.getSmokingRecord();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the {@code identityNumber} of the {@code Person} that we are building.
     */
    public PersonBuilder withIdentityNumber(String identityNumber) {
        this.identityNumber = new IdentityNumber(identityNumber);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code dateOfBirth} of the {@code Person} that we are building.
     */
    public PersonBuilder withDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = new DateOfBirth(dateOfBirth);
        return this;
    }

    /**
     * Sets the {@code bloodType} of the {@code Person} that we are building.
     */
    public PersonBuilder withBloodType(String bloodType) {
        this.bloodType = new BloodType(bloodType);
        return this;
    }

    /**
     * Sets the {@code alcoholicRecord} of the {@code Person} that we are building.
     */
    public PersonBuilder withAlcoholicRecord(String alcoholicRecord) {
        this.alcoholicRecord = new AlcoholicRecord(alcoholicRecord);
        return this;
    }

    /**
     * Sets the {@code Gender} of the {@code Person} that we are building.
     */
    public PersonBuilder withGender(String gender) {
        this.gender = new Gender(gender);
        return this;
    }
    /**
     * Sets the {@code smokingRecord} of the {@code Person} that we are building.
     */
    public PersonBuilder withSmokingRecord(String smokingRecord) {
        this.smokingRecord = new SmokingRecord(smokingRecord);
        return this;
    }

    /**
     * Builds the {@code Person} with the specified parameters.
     */
    public Person build() {
        return new Person(name, identityNumber, phone, email, address, tags, dateOfBirth, bloodType, alcoholicRecord,
                gender, smokingRecord);
    }
}
