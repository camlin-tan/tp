package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.ui.UiManager;

/**
 * Changes the UI theme of the application.
 */
public class ThemeCommand extends Command {

    public static final String COMMAND_WORD = "theme";

    public static final String MESSAGE_USAGE = "Available themes include (light/dark/pink/blue)\n"
            + "Example: " + COMMAND_WORD + " light";

    public static final String MESSAGE_SUCCESS = "Theme changed to %s.";

    private final String theme;
    private final UiManager uiManager;

    /**
     * Creates a ThemeCommand to change the UI theme.
     *
     * @param theme The theme to switch to.
     * @param uiManager The UiManager instance to handle the theme change.
     */
    public ThemeCommand(String theme, UiManager uiManager) {
        requireNonNull(theme);
        this.theme = theme.toLowerCase();
        this.uiManager = uiManager;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (!isValidTheme(theme)) {
            throw new CommandException(MESSAGE_USAGE);
        }
        if (uiManager == null) {
            throw new CommandException("UI Manager not provided.");
        }
        uiManager.switchTheme(theme);
        return new CommandResult(String.format(MESSAGE_SUCCESS, theme));
    }

    private boolean isValidTheme(String theme) {
        return theme.equals("light")
                || theme.equals("dark")
                || theme.equals("pink")
                || theme.equals("blue");
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ThemeCommand // instanceof handles nulls
                && theme.equals(((ThemeCommand) other).theme));
    }
}
