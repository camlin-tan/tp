package seedu.address.ui;

import java.util.Set;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
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

    /**
     * Creates a {@code PersonViewPanel} with the given {@code Person}.
     */
    public PersonViewPanel(Person person) {
        super(FXML);
        this.person = person;

        // Load the external CSS file
        getRoot().getStylesheets().add(getClass().getResource("/view/PersonViewPanel.css").toExternalForm());

        fillPersonDetails();
    }

    /**
     * Fills in the person's details for viewing.
     */
    private void fillPersonDetails() {
        // Set main name
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
     * Adds a new row (field name and value) to a given GridPane.
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

        int newRowIndex = grid.getRowCount();
        grid.add(fieldLabel, 0, newRowIndex);
        grid.add(valueLabel, 1, newRowIndex);
    }

    /**
     * Populates a FlowPane with styled labels from a Set.
     * If the set is empty, it adds a "None" label.
     *
     * @param pane The FlowPane to populate.
     * @param items The Set of items (e.g., allergies, medicines) to display.
     */
    private void populateFlowPane(FlowPane pane, Set<?> items) {
        if (items == null || items.isEmpty()) {
            Label noneLabel = new Label("None");
            noneLabel.getStyleClass().add(NONE_TAG_STYLE_CLASS);
            pane.getChildren().add(noneLabel);
            return;
        }

        for (Object item : items) {
            Label itemLabel = new Label(item.toString());
            itemLabel.getStyleClass().add(TAG_STYLE_CLASS);
            pane.getChildren().add(itemLabel);
        }
    }
}
