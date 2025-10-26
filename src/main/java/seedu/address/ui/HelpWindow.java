package seedu.address.ui;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Controller for a help page that shows help content.
 */
public class HelpWindow extends UiPart<Stage> {

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";
    private static final String AVAILABLECOMMANDSPATH = "/docs/AvailableCommands.txt";

    @FXML
    private TextArea helpContent;

    /**
     * Creates a HelpWindow using the given Stage as the root.
     *
     * @param root The Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        loadHelpContent();
    }

    /**
     * Creates a HelpWindow with a new Stage.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Loads the Available Commands text file into the TextArea.
     * If the file is not found or an error occurs, an error message is displayed.
     */
    private void loadHelpContent() {
        helpContent.getStylesheets().add(getClass().getResource("/view/HelpWindow.css").toExternalForm());

        try (InputStream input = getClass().getResourceAsStream(AVAILABLECOMMANDSPATH)) {
            if (input == null) {
                helpContent.setText("Available Commands file not found");
                return;
            }

            // Read the raw text file
            String helpText = new String(input.readAllBytes(), StandardCharsets.UTF_8);

            // Set the raw text directly into the TextArea
            helpContent.setText(helpText);

            // Make the TextArea read-only and wrap text
            helpContent.setEditable(false);
            helpContent.setWrapText(true);

        } catch (IOException e) {
            helpContent.setText("Error loading Available Commands file.");
        }
    }

    /**
     * Shows the help window.
     */
    public void show() {
        logger.fine("Showing help page.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    public boolean isShowing() {
        return getRoot().isShowing();
    }

    public void hide() {
        getRoot().hide();
    }

    public void focus() {
        getRoot().requestFocus();
    }
}
