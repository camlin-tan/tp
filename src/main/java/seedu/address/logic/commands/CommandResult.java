package seedu.address.logic.commands;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Person;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;
    private final Person personToView;
    private final boolean isHelp;
    private final boolean isExit;
    private final boolean isViewAppointments;

    /**
     * Constructor for most commands.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, null, false, false, false);
    }

    /**
     * Constructor for help and exit command.
     */
    public CommandResult(String feedbackToUser, boolean isHelp, boolean isExit) {
        this(feedbackToUser, null, isHelp, isExit, false);
    }

    /**
     * Constructor for view command.
     */
    public CommandResult(String feedbackToUser, Person personToView) {
        this(feedbackToUser, personToView, false, false, false);
    }

    /**
     * Constructor for appointments command.
     */
    public CommandResult(String feedbackToUser, boolean showAppointments) {
        this(feedbackToUser, null, false, false, showAppointments);
    }

    /**
     * Full constructor.
     */
    public CommandResult(String feedbackToUser, Person personToView,
                         boolean isHelp, boolean isExit, boolean isViewAppointments) {
        this.feedbackToUser = feedbackToUser;
        this.isHelp = isHelp;
        this.isExit = isExit;
        this.personToView = personToView;
        this.isViewAppointments = isViewAppointments;
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
                && Objects.equals(this.personToView, otherCommandResult.personToView);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("feedbackToUser", feedbackToUser)
                .add("personToView", personToView)
                .add("isHelp", isHelp)
                .add("isExit", isExit)
                .add("isViewAppointments", isViewAppointments)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, personToView, isHelp, isExit, isViewAppointments);
    }
}
