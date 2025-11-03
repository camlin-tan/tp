package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.AddressBook;
import seedu.address.model.Model;

/**
 * Clears the address book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "HealthNote has been cleared!";
    public static final String CONFIRMATION_ARGUMENT = "CONFIRM";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Clears all data in HealthNote. \n"
            + "To confirm, type '" + COMMAND_WORD + " " + CONFIRMATION_ARGUMENT + "'. "
            + "This action cannot be undone. ";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setAddressBook(new AddressBook());
        model.setViewedPerson(null);
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof ClearCommand; // instanceof handles nulls
    }
}
