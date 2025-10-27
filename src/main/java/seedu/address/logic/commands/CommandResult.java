package seedu.address.logic.commands;

import java.util.Objects;
import java.util.Optional;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Person;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;
    private final boolean showHelp;
    private final boolean exit;
    private final Person personToView;
    private final Optional<String> themePath;

    /**
     * Constructor for most commands.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, false, false, null);
    }

    /**
     * Constructor for help and exit command.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit) {
        this(feedbackToUser, showHelp, exit, null);
    }

    /**
     * Constructor for view command.
     */
    public CommandResult(String feedbackToUser, Person personToView) {
        this(feedbackToUser, false, false, personToView);
    }

    /**
     * Constructor for the theme command.
     */
    public CommandResult(String feedbackToUser, String themePath) {
        this(feedbackToUser, false, false, null, Optional.of(themePath));
    }

    /**
     * Constructor that calls the full constructor with a default empty theme.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit, Person personToView) {
        this(feedbackToUser, showHelp, exit, personToView, Optional.empty());
    }

    /**
     * The full constructor.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit, Person personToView,
                         Optional<String> themePath) {
        this.feedbackToUser = feedbackToUser;
        this.showHelp = showHelp;
        this.exit = exit;
        this.personToView = personToView;
        this.themePath = themePath;
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    public boolean isShowHelp() {
        return showHelp;
    }

    public boolean isExit() {
        return exit;
    }

    public Person getPersonToView() {
        return personToView;
    }

    public boolean isView() {
        return personToView != null;
    }

    public Optional<String> getThemePath() {
        return themePath;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CommandResult)) {
            return false;
        }

        CommandResult otherCommandResult = (CommandResult) other;
        return feedbackToUser.equals(otherCommandResult.feedbackToUser)
                && showHelp == otherCommandResult.showHelp
                && exit == otherCommandResult.exit
                && Objects.equals(personToView, otherCommandResult.personToView)
                && Objects.equals(themePath, otherCommandResult.themePath);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("feedbackToUser", feedbackToUser)
                .add("showHelp", showHelp)
                .add("exit", exit)
                .add("personToView", personToView)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, showHelp, exit, personToView, themePath);
    }
}
