package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.logic.parser.ParserUtil.MESSAGE_INVALID_INDEX;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ViewCommand;

public class ViewCommandParserTest {
    private ViewCommandParser parser = new ViewCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", MESSAGE_INVALID_INDEX + "\n" + ViewCommand.MESSAGE_USAGE);
    }

    @Test
    public void parse_validArgs_returnsViewCommand() {
        // valid index
        ViewCommand expectedViewCommand = new ViewCommand(seedu.address.commons.core.index.Index.fromOneBased(1));
        assertParseSuccess(parser, "1", expectedViewCommand);
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", MESSAGE_INVALID_INDEX + "\n" + ViewCommand.MESSAGE_USAGE);
    }
}

