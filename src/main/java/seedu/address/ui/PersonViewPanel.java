package seedu.address.ui;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.person.Person;

/**
 * Panel containing the viewed person's details.
 */
public class PersonViewPanel extends UiPart<Region> {

    private static final String FXML = "PersonViewPanel.fxml";

    // CSS Style classes
    private static final String TAG_STYLE_CLASS = "person-view-tag";
    private static final String NONE_TAG_STYLE_CLASS = "person-view-none-tag";
    private static final String FIELD_LABEL_STYLE_CLASS = "person-view-field-label";
    private static final String VALUE_LABEL_STYLE_CLASS = "person-view-value-label";

    private final Person person;

    @FXML
    private VBox personViewContainer;

    @FXML
    private Label nameLabel;

    @FXML
    private GridPane personalInfoGrid;

    @FXML
    private GridPane medicalInfoGrid;

    @FXML
    private FlowPane allergiesFlowPane;

    @FXML
    private FlowPane pastDiagnosisFlowPane;

    @FXML
    private FlowPane medicineFlowPane;

    @FXML
    private VBox upcomingAppointmentsBox;

    @FXML
    private VBox pastAppointmentsBox;

    /**
     * Creates a {@code PersonViewPanel} with the given {@code Person} and their {@code appointments}.
     *
     * @param person The person whose details are to be displayed.
     * @param appointments The list of appointments associated with the person.
     */
    public PersonViewPanel(Person person, ObservableList<Appointment> appointments) {
        super(FXML);
        this.person = person;
        getRoot().getStylesheets().add(getClass().getResource("/view/PersonViewPanel.css").toExternalForm());

        fillPersonDetails();
        fillAppointments(appointments);
    }

    /**
     * Fills in the person's details for viewing.
     */
    private void fillPersonDetails() {
        nameLabel.setText(person.getName().fullName);

        // Personal Info
        addGridRow(personalInfoGrid, "Identity Number:", person.getIdentityNumber().identityNumber);
        addGridRow(personalInfoGrid, "Date of Birth:", person.getDateOfBirth().toString()
                + " (" + person.getDateOfBirth().calculateAge() + " yrs old)");
        addGridRow(personalInfoGrid, "Gender:", person.getGender().toString());
        addGridRow(personalInfoGrid, "Phone:", person.getPhone().value);
        addGridRow(personalInfoGrid, "Email:", person.getEmail().value);
        addGridRow(personalInfoGrid, "Address:", person.getAddress().value);

        // Medical Info
        addGridRow(medicalInfoGrid, "Emergency Contact:", person.getEmergencyContact().toString());
        addGridRow(medicalInfoGrid, "Blood Type:", person.getBloodType().toString());
        addGridRow(medicalInfoGrid, "Alcoholic Record:", person.getAlcoholicRecord().toString());
        addGridRow(medicalInfoGrid, "Smoking Record:", person.getSmokingRecord().toString());
        addGridRow(medicalInfoGrid, "Past Diagnoses:", person.getPastDiagnoses().toString());

        // Lists
        populateFlowPane(allergiesFlowPane, person.getAllergies());
        populateFlowPane(medicineFlowPane, person.getMedicines());
    }

    /**
     * Fills in the person's appointments, separating them into upcoming and past sections.
     * Clears previous appointment content before adding new items.
     *
     * @param appointments The list of appointments for the person (expected to be sorted chronologically).
     */
    private void fillAppointments(ObservableList<Appointment> appointments) {
        upcomingAppointmentsBox.getChildren().clear(); // Clear previous content
        pastAppointmentsBox.getChildren().clear();   // Clear previous content

        if (appointments == null || appointments.isEmpty()) {
            Label noUpcoming = new Label("None");
            noUpcoming.getStyleClass().add(NONE_TAG_STYLE_CLASS);
            upcomingAppointmentsBox.getChildren().add(noUpcoming);

            Label noPast = new Label("None");
            noPast.getStyleClass().add(NONE_TAG_STYLE_CLASS);
            pastAppointmentsBox.getChildren().add(noPast);
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        boolean hasUpcoming = false;
        boolean hasPast = false;

        // Appointments list is assumed to be sorted chronologically (oldest first) by ModelManager
        for (Appointment appt : appointments) {
            Label apptLabel = new Label(formatAppointmentForDisplay(appt));
            apptLabel.getStyleClass().add(VALUE_LABEL_STYLE_CLASS); // Use existing style
            apptLabel.setWrapText(true);

            if (appt.isAfterNow()) { // Check if appointment is in the future
                upcomingAppointmentsBox.getChildren().add(apptLabel); // Add to end (maintains chronological order)
                hasUpcoming = true;
            } else { // Appointment is now or in the past
                // Add past appointments in reverse chronological order (most recent first)
                // Since the source list is sorted chronologically (oldest first), add to the beginning of the VBox
                pastAppointmentsBox.getChildren().add(0, apptLabel);
                hasPast = true;
            }
        }

        // Add "None" label if a section ended up empty
        if (!hasUpcoming) {
            Label noUpcoming = new Label("None");
            noUpcoming.getStyleClass().add(NONE_TAG_STYLE_CLASS);
            upcomingAppointmentsBox.getChildren().add(noUpcoming);
        }
        if (!hasPast) {
            Label noPast = new Label("None");
            noPast.getStyleClass().add(NONE_TAG_STYLE_CLASS);
            pastAppointmentsBox.getChildren().add(noPast);
        }
    }

    /**
     * Formats an appointment's date, time, and notes for display in the view panel.
     *
     * @param appointment The appointment to format.
     * @return A formatted string representation.
     */
    private String formatAppointmentForDisplay(Appointment appointment) {
        String dateTimeStr = appointment.getDateTime().toString(); //
        String notesStr = appointment.getNotes().toString(); //
        return dateTimeStr + (notesStr.isEmpty() ? "" : ": " + notesStr);
    }

    /**
     * Adds a new row (field name and value) to a given GridPane.
     * Aligns field names to the top-right and allows values to wrap.
     *
     * @param grid The GridPane to add to.
     * @param fieldName The text for the field label (e.g., "Phone:").
     * @param value The text for the value label.
     */
    private void addGridRow(GridPane grid, String fieldName, String value) {
        Label fieldLabel = new Label(fieldName);
        fieldLabel.getStyleClass().add(FIELD_LABEL_STYLE_CLASS);
        fieldLabel.setAlignment(Pos.TOP_RIGHT);

        Label valueLabel = new Label(value);
        valueLabel.getStyleClass().add(VALUE_LABEL_STYLE_CLASS);
        valueLabel.setWrapText(true);

        int newRowIndex = grid.getRowCount();
        grid.add(fieldLabel, 0, newRowIndex);
        grid.add(valueLabel, 1, newRowIndex);
    }

    /**
     * Populates a FlowPane with styled labels from a Set of items (like Allergies or Medicines).
     * If the set is empty or null, it adds a "None" label.
     *
     * @param pane The FlowPane to populate.
     * @param items The Set of items to display. Items should have a meaningful `toString()` representation.
     */
    private void populateFlowPane(FlowPane pane, Set<?> items) {
        pane.getChildren().clear();

        if (items == null || items.isEmpty()) {
            Label noneLabel = new Label("None");
            noneLabel.getStyleClass().add(NONE_TAG_STYLE_CLASS);
            pane.getChildren().add(noneLabel);
            return;
        }

        List<String> sortedItemStrings = items.stream()
                .map(Object::toString)
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .toList();

        for (String itemStr : sortedItemStrings) {
            Label itemLabel = new Label(itemStr);
            itemLabel.getStyleClass().add(TAG_STYLE_CLASS); // Reuse tag styling
            pane.getChildren().add(itemLabel);
        }
    }
}
