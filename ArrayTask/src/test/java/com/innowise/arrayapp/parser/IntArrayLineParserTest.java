package com.innowise.arrayapp.parser;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.innowise.arrayapp.exception.ArrayDataException;
import org.junit.jupiter.api.Test;

class IntArrayLineParserTest {

    private static final String VALID_LINE = "1, 2, 3";
    private static final int[] EXPECTED_VALUES_FROM_VALID_LINE = {1, 2, 3};
    private static final String LINE_WITH_SPACES = " 10 , -20 ";
    private static final int[] EXPECTED_VALUES_FROM_SPACED_LINE = {10, -20};
    private static final String INVALID_NUMBER_LINE = "1, x3";
    private static final String EMPTY_LINE = "";
    private static final String BLANK_LINE = "   ";

    private final LineParser parser = new IntArrayLineParser();

    @Test
    void parseLineShouldReturnValuesForValidLine() throws ArrayDataException {
        // given
        // when
        int[] actualValues = parser.parseLine(VALID_LINE);
        // then
        assertArrayEquals(EXPECTED_VALUES_FROM_VALID_LINE, actualValues);
    }

    @Test
    void parseLineShouldIgnoreSpacesAroundNumbers() throws ArrayDataException {
        // given
        // when
        int[] actualValues = parser.parseLine(LINE_WITH_SPACES);
        // then
        assertArrayEquals(EXPECTED_VALUES_FROM_SPACED_LINE, actualValues);
    }

    @Test
    void parseLineShouldThrowForInvalidNumber() {
        // given
        // when and then
        assertThrows(ArrayDataException.class, () -> parser.parseLine(INVALID_NUMBER_LINE));
    }

    @Test
    void parseLineShouldThrowForEmptyLine() {
        // given
        // when and then
        assertThrows(ArrayDataException.class, () -> parser.parseLine(EMPTY_LINE));
    }

    @Test
    void parseLineShouldThrowForBlankLine() {
        // given
        // when and then
        assertThrows(ArrayDataException.class, () -> parser.parseLine(BLANK_LINE));
    }
}
