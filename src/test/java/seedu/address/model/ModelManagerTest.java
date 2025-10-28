package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalAppointments.APPT_ALICE;
import static seedu.address.testutil.TypicalAppointments.APPT_BENSON;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BENSON;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.person.NameOrIdContainsKeywordsPredicate;
import seedu.address.testutil.AddressBookBuilder;
import seedu.address.testutil.AppointmentBuilder;

public class ModelManagerTest {

    private ModelManager modelManager = new ModelManager();

    @Test
    public void constructor() {
        assertEquals(new UserPrefs(), modelManager.getUserPrefs());
        assertEquals(new GuiSettings(), modelManager.getGuiSettings());
        assertEquals(new AddressBook(), new AddressBook(modelManager.getAddressBook()));
    }

    @Test
    public void setUserPrefs_nullUserPrefs_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setUserPrefs(null));
    }

    @Test
    public void setUserPrefs_validUserPrefs_copiesUserPrefs() {
        UserPrefs userPrefs = new UserPrefs();
        userPrefs.setAddressBookFilePath(Paths.get("address/book/file/path"));
        userPrefs.setGuiSettings(new GuiSettings(1, 2, 3, 4));
        modelManager.setUserPrefs(userPrefs);
        assertEquals(userPrefs, modelManager.getUserPrefs());

        // Modifying userPrefs should not modify modelManager's userPrefs
        UserPrefs oldUserPrefs = new UserPrefs(userPrefs);
        userPrefs.setAddressBookFilePath(Paths.get("new/address/book/file/path"));
        assertEquals(oldUserPrefs, modelManager.getUserPrefs());
    }

    @Test
    public void setGuiSettings_nullGuiSettings_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setGuiSettings(null));
    }

    @Test
    public void setGuiSettings_validGuiSettings_setsGuiSettings() {
        GuiSettings guiSettings = new GuiSettings(1, 2, 3, 4);
        modelManager.setGuiSettings(guiSettings);
        assertEquals(guiSettings, modelManager.getGuiSettings());
    }

    @Test
    public void setAddressBookFilePath_nullPath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setAddressBookFilePath(null));
    }

    @Test
    public void setAddressBookFilePath_validPath_setsAddressBookFilePath() {
        Path path = Paths.get("address/book/file/path");
        modelManager.setAddressBookFilePath(path);
        assertEquals(path, modelManager.getAddressBookFilePath());
    }

    @Test
    public void hasPerson_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.hasPerson(null));
    }

    @Test
    public void hasPerson_personNotInAddressBook_returnsFalse() {
        assertFalse(modelManager.hasPerson(ALICE));
    }

    @Test
    public void hasPerson_personInAddressBook_returnsTrue() {
        modelManager.addPerson(ALICE);
        assertTrue(modelManager.hasPerson(ALICE));
    }

    @Test
    public void deletePerson_personExists_removesPersonAndAssociatedAppointments() {
        modelManager.addPerson(ALICE);
        Appointment appointmentForAlice =
                new AppointmentBuilder(APPT_ALICE).withPatientId(ALICE.getIdentityNumber()).build();
        Appointment appointmentForBenson =
                new AppointmentBuilder(APPT_BENSON).withPatientId(BENSON.getIdentityNumber()).build();
        modelManager.addAppointment(appointmentForAlice);
        modelManager.addAppointment(appointmentForBenson);

        assertTrue(modelManager.hasPerson(ALICE));
        assertTrue(modelManager.hasAppointment(appointmentForAlice));
        assertTrue(modelManager.hasAppointment(appointmentForBenson));

        modelManager.deletePerson(ALICE);

        assertFalse(modelManager.hasPerson(ALICE));
        assertFalse(modelManager.hasAppointment(appointmentForAlice));
        assertTrue(modelManager.hasAppointment(appointmentForBenson));
    }


    @Test
    public void getFilteredPersonList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> modelManager.getFilteredPersonList().remove(0));
    }

    @Test
    public void hasAppointment_nullAppointment_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.hasAppointment(null));
    }

    @Test
    public void hasAppointment_appointmentNotInAddressBook_returnsFalse() {
        assertFalse(modelManager.hasAppointment(APPT_ALICE));
    }

    @Test
    public void hasAppointment_appointmentInAddressBook_returnsTrue() {
        modelManager.addAppointment(APPT_ALICE);
        assertTrue(modelManager.hasAppointment(APPT_ALICE));
    }

    @Test
    public void getFilteredAppointmentList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(
                UnsupportedOperationException.class, () -> modelManager.getFilteredAppointmentList().remove(0));
    }

    @Test
    public void addAppointment_appointmentAddedSuccessfully() {
        modelManager.addAppointment(APPT_BENSON);
        assertTrue(modelManager.hasAppointment(APPT_BENSON));
    }

    @Test
    public void updateViewedPersonAppointmentList_nullList_throwsNullPointerException() {
        assertThrows(
                NullPointerException.class, () -> modelManager.updateViewedPersonAppointmentList(null));
    }

    @Test
    public void updateViewedPersonAppointmentList_emptyList_clearsBothLists() {
        Appointment future = new AppointmentBuilder()
                .withTime(LocalDateTime.now().plusDays(1).format(AppointmentBuilder.FORMATTER))
                .build();
        Appointment past = new AppointmentBuilder()
                .withTime(LocalDateTime.now().minusDays(1).format(AppointmentBuilder.FORMATTER))
                .build();
        modelManager.updateViewedPersonAppointmentList(Arrays.asList(future, past));
        assertFalse(modelManager.getViewedPersonUpcomingAppointmentList().isEmpty());
        assertFalse(modelManager.getViewedPersonPastAppointmentList().isEmpty());

        // Update with empty list
        modelManager.updateViewedPersonAppointmentList(Collections.emptyList());
        assertTrue(modelManager.getViewedPersonUpcomingAppointmentList().isEmpty());
        assertTrue(modelManager.getViewedPersonPastAppointmentList().isEmpty());
    }

    @Test
    public void updateViewedPersonAppointmentList_onlyUpcoming_populatesUpcomingCorrectly() {
        Appointment future1 = new AppointmentBuilder()
                .withPatientId(ALICE.getIdentityNumber())
                .withTime(LocalDateTime.now().plusDays(2).format(AppointmentBuilder.FORMATTER))
                .withNotes("Future 1").build();
        Appointment future2 = new AppointmentBuilder()
                .withPatientId(ALICE.getIdentityNumber())
                .withTime(LocalDateTime.now().plusDays(1).format(AppointmentBuilder.FORMATTER))
                .withNotes("Future 2").build(); // Earlier future
        List<Appointment> appointments = Arrays.asList(future1, future2);

        modelManager.updateViewedPersonAppointmentList(appointments);

        ObservableList<Appointment> upcoming = modelManager.getViewedPersonUpcomingAppointmentList();
        assertEquals(2, upcoming.size());
        assertEquals(future2, upcoming.get(0)); // Should be sorted chronologically
        assertEquals(future1, upcoming.get(1));
        assertTrue(modelManager.getViewedPersonPastAppointmentList().isEmpty());
    }

    @Test
    public void updateViewedPersonAppointmentList_onlyPast_populatesPastCorrectly() {
        Appointment past1 = new AppointmentBuilder()
                .withPatientId(ALICE.getIdentityNumber())
                .withTime(LocalDateTime.now().minusDays(2).format(AppointmentBuilder.FORMATTER))
                .withNotes("Past 1").build(); // Older past
        Appointment past2 = new AppointmentBuilder()
                .withPatientId(ALICE.getIdentityNumber())
                .withTime(LocalDateTime.now().minusDays(1).format(AppointmentBuilder.FORMATTER))
                .withNotes("Past 2").build();
        List<Appointment> appointments = Arrays.asList(past1, past2);

        modelManager.updateViewedPersonAppointmentList(appointments);

        ObservableList<Appointment> past = modelManager.getViewedPersonPastAppointmentList();
        assertEquals(2, past.size());
        assertEquals(past2, past.get(0)); // Should be sorted reverse chronologically (most recent first)
        assertEquals(past1, past.get(1));
        assertTrue(modelManager.getViewedPersonUpcomingAppointmentList().isEmpty());
    }


    @Test
    public void updateViewedPersonAppointmentList_mixedAppointments_populatesBothCorrectly() {
        Appointment future1 = new AppointmentBuilder()
                .withPatientId(ALICE.getIdentityNumber())
                .withTime(LocalDateTime.now().plusDays(2).format(AppointmentBuilder.FORMATTER))
                .withNotes("Future 1").build();
        Appointment future2 = new AppointmentBuilder()
                .withPatientId(ALICE.getIdentityNumber())
                .withTime(LocalDateTime.now().plusDays(1).format(AppointmentBuilder.FORMATTER))
                .withNotes("Future 2").build();
        Appointment past1 = new AppointmentBuilder().withPatientId(ALICE.getIdentityNumber())
                .withTime(LocalDateTime.now().minusDays(2).format(AppointmentBuilder.FORMATTER))
                .withNotes("Past 1").build();
        Appointment past2 = new AppointmentBuilder()
                .withPatientId(ALICE.getIdentityNumber())
                .withTime(LocalDateTime.now().minusDays(1).format(AppointmentBuilder.FORMATTER))
                .withNotes("Past 2").build();
        List<Appointment> appointments = Arrays.asList(future1, past1, future2, past2); // Unsorted mix

        modelManager.updateViewedPersonAppointmentList(appointments);

        ObservableList<Appointment> upcoming = modelManager.getViewedPersonUpcomingAppointmentList();
        assertEquals(2, upcoming.size());
        assertEquals(future2, upcoming.get(0)); // Sorted upcoming
        assertEquals(future1, upcoming.get(1));

        ObservableList<Appointment> past = modelManager.getViewedPersonPastAppointmentList();
        assertEquals(2, past.size());
        assertEquals(past2, past.get(0)); // Sorted past (reverse chronological)
        assertEquals(past1, past.get(1));
    }


    @Test
    public void clearViewedPersonAppointmentList_clearsBothLists() {
        Appointment future = new AppointmentBuilder()
                .withTime(LocalDateTime.now().plusDays(1).format(AppointmentBuilder.FORMATTER))
                .build();
        Appointment past = new AppointmentBuilder()
                .withTime(LocalDateTime.now().minusDays(1).format(AppointmentBuilder.FORMATTER))
                .build();
        modelManager.updateViewedPersonAppointmentList(Arrays.asList(future, past));

        modelManager.clearViewedPersonAppointmentList();

        assertTrue(modelManager.getViewedPersonUpcomingAppointmentList().isEmpty());
        assertTrue(modelManager.getViewedPersonPastAppointmentList().isEmpty());
    }

    @Test
    public void equals() {
        AddressBook addressBook = new AddressBookBuilder().withPerson(ALICE).withPerson(BENSON)
                .withAppointment(APPT_ALICE).withAppointment(APPT_BENSON).build();
        AddressBook differentAddressBook = new AddressBook();
        UserPrefs userPrefs = new UserPrefs();

        // same values -> returns true
        modelManager = new ModelManager(addressBook, userPrefs);
        ModelManager modelManagerCopy = new ModelManager(addressBook, userPrefs);
        assertTrue(modelManager.equals(modelManagerCopy));

        // same object -> returns true
        assertTrue(modelManager.equals(modelManager));

        // null -> returns false
        assertFalse(modelManager.equals(null));

        // different types -> returns false
        assertFalse(modelManager.equals(5));

        // different addressBook -> returns false
        assertFalse(modelManager.equals(new ModelManager(differentAddressBook, userPrefs)));

        // different filteredPersonList -> returns false
        String[] keywords = ALICE.getName().fullName.split("\\s+");
        modelManager.updateFilteredPersonList(new NameOrIdContainsKeywordsPredicate(Arrays.asList(keywords)));
        assertFalse(modelManager.equals(new ModelManager(addressBook, userPrefs)));

        // resets modelManager to initial state for upcoming tests
        modelManager.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);

        // different userPrefs -> returns false
        UserPrefs differentUserPrefs = new UserPrefs();
        differentUserPrefs.setAddressBookFilePath(Paths.get("differentFilePath"));
        assertFalse(modelManager.equals(new ModelManager(addressBook, differentUserPrefs)));

        // different filteredAppointmentList -> returns false
        modelManager.updateFilteredAppointmentList(a -> a.equals(APPT_ALICE));
        assertFalse(modelManager.equals(new ModelManager(addressBook, userPrefs)));

        // resets modelManager to initial state
        modelManager.updateFilteredAppointmentList(a -> true);

        // different viewedPersonUpcomingAppointmentList -> returns false
        ModelManager modelManagerWithUpcoming = new ModelManager(addressBook, userPrefs);
        Appointment future = new AppointmentBuilder()
                .withTime(LocalDateTime.now().plusDays(1).format(AppointmentBuilder.FORMATTER))
                .build();
        modelManagerWithUpcoming.updateViewedPersonAppointmentList(Collections.singletonList(future));
        assertFalse(modelManager.equals(modelManagerWithUpcoming));

        // different viewedPersonPastAppointmentList -> returns false
        ModelManager modelManagerWithPast = new ModelManager(addressBook, userPrefs);
        Appointment past = new AppointmentBuilder()
                .withTime(LocalDateTime.now().minusDays(1).format(AppointmentBuilder.FORMATTER))
                .build();
        modelManagerWithPast.updateViewedPersonAppointmentList(Collections.singletonList(past));
        assertFalse(modelManager.equals(modelManagerWithPast));
    }

}
