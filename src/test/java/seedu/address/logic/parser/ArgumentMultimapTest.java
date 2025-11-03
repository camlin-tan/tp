package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import seedu.address.logic.parser.exceptions.ParseException;

public class ArgumentMultimapTest {

    @Test
    public void put_putSingleValue_retrievedViaGetValue() {
        ArgumentMultimap map = new ArgumentMultimap();
        map.put(PREFIX_NAME, "John Doe");
        assertEquals(Optional.of("John Doe"), map.getValue(PREFIX_NAME));
    }

    @Test
    public void put_putMultipleValues_retrievedViaGetAllValues() {
        ArgumentMultimap map = new ArgumentMultimap();
        map.put(PREFIX_NAME, "John Doe");
        map.put(PREFIX_NAME, "Jane Doe");
        List<String> expected = Arrays.asList("John Doe", "Jane Doe");
        assertEquals(expected, map.getAllValues(PREFIX_NAME));
    }

    @Test
    public void getValue_noValuePresent_returnsEmptyOptional() {
        ArgumentMultimap map = new ArgumentMultimap();
        assertEquals(Optional.empty(), map.getValue(PREFIX_NAME));
    }

    @Test
    public void getPreamble_noPreamble_returnsEmptyString() {
        ArgumentMultimap map = new ArgumentMultimap();
        assertEquals("", map.getPreamble());
    }

    @Test
    public void getPreamble_hasPreamble_returnsPreamble() {
        ArgumentMultimap map = new ArgumentMultimap();
        map.put(new Prefix(""), "My Preamble");
        assertEquals("My Preamble", map.getPreamble());
    }


    @Test
    public void verifyNoDuplicatePrefixesFor_oneDuplicate_throwsParseException() {
        ArgumentMultimap map = new ArgumentMultimap();
        map.put(PREFIX_NAME, "John");
        map.put(PREFIX_NAME, "Jane");
        map.put(PREFIX_ADDRESS, "123 Street");

        try {
            map.verifyNoDuplicatePrefixesFor(PREFIX_NAME, PREFIX_ADDRESS);
        } catch (ParseException e) {
            String expectedMessage = "Multiple values specified for the following single-valued field(s): n\\";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void verifyNoDuplicatePrefixesFor_multipleDuplicates_throwsParseException() {
        ArgumentMultimap map = new ArgumentMultimap();
        map.put(PREFIX_NAME, "John");
        map.put(PREFIX_NAME, "Jane");
        map.put(PREFIX_ADDRESS, "123 Street");
        map.put(PREFIX_ADDRESS, "456 Avenue");

        try {
            map.verifyNoDuplicatePrefixesFor(PREFIX_NAME, PREFIX_ADDRESS);
        } catch (ParseException e) {
            String message = e.getMessage();
            assertTrue(message.contains("n\\"));
            assertTrue(message.contains("addr\\"));
        }
    }

    @Test
    public void getValueOrResetIfEmpty_valuePresent_returnsValue() {
        ArgumentMultimap map = new ArgumentMultimap();
        map.put(PREFIX_NAME, "John");
        assertEquals("John", map.getValueOrResetIfEmpty(PREFIX_NAME).orElse(null));
    }

    @Test
    public void getValueOrResetIfEmpty_valueEmpty_returnsDefault() {
        ArgumentMultimap map = new ArgumentMultimap();
        map.put(PREFIX_NAME, "");
        assertEquals("None", map.getValueOrResetIfEmpty(PREFIX_NAME).orElse(null));
    }
}
