package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ClearCommand;

public class ClearCommandParserTest {
    private ClearCommandParser parser = new ClearCommandParser();

    @Test
    public void parse_validArgs_returnsClearCommand() {
        // test successful parse with correct confirmation argument
        assertParseSuccess(parser, ClearCommand.CONFIRMATION_ARGUMENT, new ClearCommand());

        // test with leading and trailing spaces
        assertParseSuccess(parser, "  " + ClearCommand.CONFIRMATION_ARGUMENT + "  ", new ClearCommand());
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        // test parse failure with case mismatched confirmation argument
        assertParseFailure(parser, "conFIRM",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ClearCommand.MESSAGE_USAGE));

        // test parse failure with missing confirmation argument
        assertParseFailure(parser, "",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ClearCommand.MESSAGE_USAGE));

        // test parse failure with only spaces
        assertParseFailure(parser, " ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ClearCommand.MESSAGE_USAGE));

        // test parse failure with extra arguments
        assertParseFailure(parser, ClearCommand.CONFIRMATION_ARGUMENT + " 123",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ClearCommand.MESSAGE_USAGE));
    }
}
