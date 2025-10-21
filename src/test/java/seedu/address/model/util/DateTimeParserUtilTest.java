package seedu.address.model.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DateTimeParserUtilTest {
    private static final List<DateTimeFormatter> FORMATTERS = Arrays.asList(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
            DateTimeFormatter.ISO_LOCAL_DATE_TIME
    );

    @Test
    public void parseDateTime_validIsoFormat_success() {
        String validDateTime = "2020-12-31 12:30";
        LocalDateTime expected = LocalDateTime.of(2020, 12, 31, 12, 30);
        assertEquals(expected, DateTimeParserUtil.parseDateTime(validDateTime, FORMATTERS));
    }

    @Test
    public void parseDateTime_invalidDate_throwsDateTimeParseException() {
        String invalidDateTime = "31/2/2020 12:30";
        assertThrows(DateTimeParseException.class, () -> DateTimeParserUtil.parseDateTime(invalidDateTime, FORMATTERS));
    }

    @Test
    public void parseDateTime_invalidTime_throwsDateTimeParseException() {
        String invalidDateTime = "2020-12-31 25:00";
        assertThrows(DateTimeParseException.class, () -> DateTimeParserUtil.parseDateTime(invalidDateTime, FORMATTERS));
    }

    @Test
    public void parseDateTime_invalidDateTimeFormat_throwsDateTimeParseException() {
        String invalidDateTime = "2020-30-02 12:30";
        assertThrows(DateTimeParseException.class, () -> DateTimeParserUtil.parseDateTime(invalidDateTime, FORMATTERS));
    }

    @Test
    public void parseDateTime_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> DateTimeParserUtil.parseDateTime(null, FORMATTERS));
    }

    @Test
    public void formatDateTime_formatsCorrectly() {
        LocalDateTime dateTime = LocalDateTime.of(2021, 1, 2, 12, 30);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        assertEquals("02/01/2021 12:30", DateTimeParserUtil.formatDateTime(dateTime, fmt));
    }

    @Test
    public void formatDateTime_nullDate_throwsNullPointerException() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        assertThrows(NullPointerException.class, () -> DateTimeParserUtil.formatDateTime(null, fmt));
    }

    @Test
    public void formatDateTime_nullFormatter_throwsNullPointerException() {
        LocalDateTime dateTime = LocalDateTime.now();
        assertThrows(NullPointerException.class, () -> DateTimeParserUtil.formatDateTime(dateTime, null));
    }

    @Test
    public void isValidDateTime_trueAndFalseCases() {
        assertTrue(DateTimeParserUtil.isValidDateTime("2020-12-31 12:30", FORMATTERS));
        assertFalse(DateTimeParserUtil.isValidDateTime("2020-12-31 12:60", FORMATTERS));
    }

    @Test
    public void isValidDateTime_withMultipleFormatters_true() {
        List<DateTimeFormatter> many = Arrays.asList(
                DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        );
        assertTrue(DateTimeParserUtil.isValidDateTime("31/12/2020 12:30", many));
        assertTrue(DateTimeParserUtil.isValidDateTime("2020-12-31 12:30", many));
    }

    @Test
    public void isValidDateTime_nullArguments_throwNullPointerException() {
        assertThrows(NullPointerException.class, () -> DateTimeParserUtil.isValidDateTime(null, FORMATTERS));
        assertThrows(NullPointerException.class,
                () -> DateTimeParserUtil.isValidDateTime("2020-12-31 12:30", null));
    }
}
