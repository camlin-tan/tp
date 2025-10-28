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
    private final Person personToView;
    private final Optional<String> themePath;
    private final boolean isHelp;
    private final boolean isExit;
    private final boolean isViewAppointments;

    /**
     * Constructor for most commands.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, null, false, false, false, Optional.empty());
    }

    /**
     * Constructor for help and exit command.
     */
    public CommandResult(String feedbackToUser, boolean isHelp, boolean isExit) {
        this(feedbackToUser, null, isHelp, isExit, false, Optional.empty());
    }

    /**
     * Constructor for view command.
     */
    public CommandResult(String feedbackToUser, Person personToView) {
        this(feedbackToUser, personToView, false, false, false, Optional.empty());
    }

    /**
     * Constructor for appointments command.
     */
    public CommandResult(String feedbackToUser, boolean showAppointments) {
        this(feedbackToUser, null, false, false, showAppointments, Optional.empty());
    }

    /**
     * Constructor for the theme command.
     */
    public CommandResult(String feedbackToUser, String themePath) {
        this(feedbackToUser, null, false, false, false, Optional.of(themePath));
    }

    /**
     * Constructor that calls the full constructor with a default empty theme.
     */
    public CommandResult(String feedbackToUser, boolean isHelp, boolean isExit, Person personToView) {
        this(feedbackToUser, personToView, isHelp, isExit, false, Optional.empty());
    }

    /**
     * The full constructor.
     */
    public CommandResult(String feedbackToUser, Person personToView,
                         boolean isHelp, boolean isExit, boolean isViewAppointments, Optional<String> themePath) {
        this.feedbackToUser = feedbackToUser;
        this.isHelp = isHelp;
        this.isExit = isExit;
        this.personToView = personToView;
        this.isViewAppointments = isViewAppointments;
        this.themePath = themePath;
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    public boolean isHelp() {
        return isHelp;
    }

    public boolean isExit() {
        return isExit;
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

    public boolean isViewAppointments() {
        return isViewAppointments;
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
                && isHelp == otherCommandResult.isHelp
                && isExit == otherCommandResult.isExit
                && isViewAppointments == otherCommandResult.isViewAppointments
                && Objects.equals(this.personToView, otherCommandResult.personToView)
                && Objects.equals(themePath, otherCommandResult.themePath);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("feedbackToUser", feedbackToUser)
                .add("personToView", personToView)
                .add("isHelp", isHelp)
                .add("isExit", isExit)
                .add("isViewAppointments", isViewAppointments)
                .add("themePath", themePath)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, personToView, isHelp, isExit, isViewAppointments, themePath);
    }
}
