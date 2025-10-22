package seedu.address.model.util;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * Utility class providing functionality to parse, format, and validate date-time strings
 * based on specified formats. It leverages {@code DateTimeFormatter} for defining custom
 * date-time formats and offers convenience methods for typical usage scenarios.
 */
public class DateTimeParserUtil {

    /**
     * Parses the given date-time string using a list of {@code DateTimeFormatter} objects and returns
     * the matching {@code LocalDateTime}. If none of the formatters match, a {@code DateTimeParseException} is thrown.
     *
     * @param dateTime The date-time string to be parsed, which must conform to at least one of the formats
     *                 specified in the {@code formatters} list. Must not be null.
     * @param formatters A list of {@code DateTimeFormatter} objects that define the acceptable formats
     *                   for the date-time string. Must not be null or empty.
     * @return The parsed {@code LocalDateTime} object if the date-time string matches one of the specified formats.
     * @throws DateTimeParseException If the date-time string does not match any of the provided
     *          {@code DateTimeFormatter} formats.
     */
    public static LocalDateTime parseDateTime(String dateTime, List<DateTimeFormatter> formatters)
            throws DateTimeParseException {
        for (DateTimeFormatter formatter : formatters) {
            try {
                return LocalDateTime.parse(dateTime, formatter);
            } catch (DateTimeParseException e) {
                // continue to next formatter
            }
        }
        // should never reach here if isValidDate is called before
        throw new DateTimeParseException("Invalid date/time format", dateTime, 0);
    }

    /**
     * Formats a {@code LocalDateTime} object into a {@code String} using the provided {@code DateTimeFormatter}.
     *
     * @param dateTime The {@code LocalDateTime} to format. Must not be null.
     * @param formatter The {@code DateTimeFormatter} to use for formatting. Must not be null.
     * @return A {@code String} representation of the formatted {@code LocalDateTime}.
     */
    public static String formatDateTime(LocalDateTime dateTime, DateTimeFormatter formatter) {
        return dateTime.format(formatter);
    }

    /**
     * Validates whether the given date-time string matches any of the specified {@code DateTimeFormatter} formats.
     *
     * @param dateTimeString The date-time string to validate. Must not be null.
     * @param formatters A list of {@code DateTimeFormatter} objects that define the acceptable date-time formats.
     *                   Must not be null or empty.
     * @return {@code true} if the date-time string matches at least one of the specified formats,
     *         {@code false} otherwise.
     */
    public static boolean isValidDateTime(String dateTimeString, List<DateTimeFormatter> formatters) {
        return formatters.stream().anyMatch(formatter -> isValid(dateTimeString, formatter));
    }

    /**
     * Validates whether the given date-time string can be parsed using the specified {@code DateTimeFormatter}.
     *
     * @param dateTimeString The date-time string to be validated. Must not be null.
     * @param formatter The {@code DateTimeFormatter} to use for validation. Must not be null.
     * @return {@code true} if the date-time string can be successfully parsed using the specified formatter,
     *         {@code false} otherwise.
     */
    private static boolean isValid(String dateTimeString, DateTimeFormatter formatter) {
        try {
            LocalDate.parse(dateTimeString, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
