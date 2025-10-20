package seedu.address.logic.commands;

import seedu.address.model.person.Person;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;
    private final boolean showHelp;
    private final boolean exit;
    private final Person personToView;

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
     * Full constructor.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit, Person personToView) {
        this.feedbackToUser = feedbackToUser;
        this.showHelp = showHelp;
        this.exit = exit;
        this.personToView = personToView;
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

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof CommandResult
                && feedbackToUser.equals(((CommandResult) other).feedbackToUser)
                && showHelp == ((CommandResult) other).showHelp
                && exit == ((CommandResult) other).exit
                && ((personToView == null && ((CommandResult) other).personToView == null)
                || (personToView != null && personToView.equals(((CommandResult) other).personToView))));
    }

    @Override
    public String toString() {
        return String.format("%s (help: %b, exit: %b, view: %s)",
                feedbackToUser, showHelp, exit,
                personToView == null ? "none" : personToView.getName());
    }
}
