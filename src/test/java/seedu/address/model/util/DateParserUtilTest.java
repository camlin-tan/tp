package seedu.address.model.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DateParserUtilTest {

    private static final List<DateTimeFormatter> FORMATTERS = Arrays.asList(
            DateTimeFormatter.ISO_LOCAL_DATE
    );

    @Test
    public void parseDate_validIsoFormat_success() {
        String validDate = "2020-12-31";
        LocalDate expected = LocalDate.of(2020, 12, 31);
        assertEquals(expected, DateParserUtil.parseDate(validDate, FORMATTERS));
    }

    @Test
    public void parseDate_withMultipleFormatters_matchesFirstThatParses() {
        List<DateTimeFormatter> many = Arrays.asList(
                DateTimeFormatter.ofPattern("d/MM/yyyy"), // matches "31/12/2020"
                DateTimeFormatter.ISO_LOCAL_DATE
        );
        String date1 = "31/12/2020";
        LocalDate expected1 = LocalDate.of(2020, 12, 31);
        assertEquals(expected1, DateParserUtil.parseDate(date1, many));

        // ISO still works
        String iso = "2021-01-02";
        LocalDate expectedIso = LocalDate.of(2021, 1, 2);
        assertEquals(expectedIso, DateParserUtil.parseDate(iso, many));
    }

    @Test
    public void parseDate_emptyFormatters_throwsDateTimeParseException() {
        assertThrows(DateTimeParseException.class, () ->
                DateParserUtil.parseDate("2020-01-01", Collections.emptyList()));
    }

    @Test
    public void parseDate_invalidFormat_throwsDateTimeParseException() {
        String invalidDate = "31/12/2020";
        assertThrows(DateTimeParseException.class, () -> DateParserUtil.parseDate(invalidDate, FORMATTERS));
    }

    @Test
    public void parseDate_invalidDate_throwsDateTimeParseException() {
        String invalidDate = "2020-02-30";
        assertThrows(DateTimeParseException.class, () -> DateParserUtil.parseDate(invalidDate, FORMATTERS));
    }

    @Test
    public void parseDate_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> DateParserUtil.parseDate(null, FORMATTERS));
    }

    @Test
    public void formatDate_formatsCorrectly() {
        LocalDate date = LocalDate.of(2021, 1, 2);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        assertEquals("02/01/2021", DateParserUtil.formatDate(date, fmt));
    }

    @Test
    public void formatDate_nullDate_throwsNullPointerException() {
        DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;
        assertThrows(NullPointerException.class, () -> DateParserUtil.formatDate(null, fmt));
    }

    @Test
    public void formatDate_nullFormatter_throwsNullPointerException() {
        LocalDate date = LocalDate.now();
        assertThrows(NullPointerException.class, () -> DateParserUtil.formatDate(date, null));
    }

    @Test
    public void isValidDate_trueAndFalseCases() {
        assertTrue(DateParserUtil.isValidDate("2020-12-31", FORMATTERS));
        assertFalse(DateParserUtil.isValidDate("31/12/2020", FORMATTERS));
    }

    @Test
    public void isValidDate_withMultipleFormatters_true() {
        List<DateTimeFormatter> many = Arrays.asList(
                DateTimeFormatter.ofPattern("d/MM/yyyy"),
                DateTimeFormatter.ISO_LOCAL_DATE
        );
        assertTrue(DateParserUtil.isValidDate("31/12/2020", many));
        assertTrue(DateParserUtil.isValidDate("2020-12-31", many));
    }

    @Test
    public void isValidDate_nullArguments_throwNullPointerException() {
        assertThrows(NullPointerException.class, () -> DateParserUtil.isValidDate(null, FORMATTERS));
        assertThrows(NullPointerException.class, () -> DateParserUtil.isValidDate("2020-12-31", null));
    }

    @Test
    public void isBeforeOrEqualToday_today_true() {
        String today = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);

        assertTrue(DateParserUtil.isBeforeOrEqualToday(today, FORMATTERS));
    }

    @Test
    public void isBeforeOrEqualToday_futureIsFalse_invalidIsFalse() {
        String today = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String tomorrow = LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE);

        assertTrue(DateParserUtil.isBeforeOrEqualToday(today, FORMATTERS));
        assertFalse(DateParserUtil.isBeforeOrEqualToday(tomorrow, FORMATTERS));
        assertFalse(DateParserUtil.isBeforeOrEqualToday("not-a-date", FORMATTERS));
    }

    @Test
    public void isBeforeOrEqualToday_withDifferentFormatter_parsesCorrectly() {
        List<DateTimeFormatter> many = Arrays.asList(
                DateTimeFormatter.ofPattern("d/MM/yyyy"),
                DateTimeFormatter.ISO_LOCAL_DATE
        );
        String dmy = LocalDate.now().format(DateTimeFormatter.ofPattern("d/MM/yyyy"));
        assertTrue(DateParserUtil.isBeforeOrEqualToday(dmy, many));
    }
}
