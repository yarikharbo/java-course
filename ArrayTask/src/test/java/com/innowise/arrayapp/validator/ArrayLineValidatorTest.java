package com.innowise.arrayapp.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ArrayLineValidatorTest {

    private static final String VALID_LINE = "1, 2, 3";
    private static final String VALID_LINE_WITH_NEGATIVES = "-5, 10 , -15";
    private static final String VALID_SINGLE_NUMBER_LINE = " 7 ";
    private static final String INVALID_SEMICOLON_LINE = "1; 2; 3";
    private static final String INVALID_DASH_LINE = "1 – 2 - 3";
    private static final String INVALID_SPACE_LINE = "3 4 7";
    private static final String INVALID_LETTERS_LINE = "1y1 21 32";
    private static final String INVALID_MIXED_LINE = "1, 2, x3, 6..5, 77";
    private static final String INVALID_EMPTY_LINE = "";
    private static final String INVALID_BLANK_LINE = "   ";
    private static final String INVALID_DOUBLE_COMMA_LINE = "1,,2";
    private static final String INVALID_TRAILING_COMMA_LINE = "1, 2,";

    private final ArrayLineValidator validator = new ArrayLineValidator();

    @Test
    void isValidLineShouldReturnTrueForValidLine() {
        // given
        // when
        boolean actual = validator.isValidLine(VALID_LINE);
        // then
        assertTrue(actual);
    }

    @Test
    void isValidLineShouldReturnTrueForLineWithNegativeNumbers() {
        // given
        // when
        boolean actual = validator.isValidLine(VALID_LINE_WITH_NEGATIVES);
        // then
        assertTrue(actual);
    }

    @Test
    void isValidLineShouldReturnTrueForSingleNumber() {
        // given
        // when
        boolean actual = validator.isValidLine(VALID_SINGLE_NUMBER_LINE);
        // then
        assertTrue(actual);
    }

    @Test
    void isValidLineShouldReturnFalseForSemicolonSeparatedLine() {
        // given
        // when
        boolean actual = validator.isValidLine(INVALID_SEMICOLON_LINE);
        // then
        assertFalse(actual);
    }

    @Test
    void isValidLineShouldReturnFalseForDashSeparatedLine() {
        // given
        // when
        boolean actual = validator.isValidLine(INVALID_DASH_LINE);
        // then
        assertFalse(actual);
    }

    @Test
    void isValidLineShouldReturnFalseForSpaceSeparatedLine() {
        // given
        // when
        boolean actual = validator.isValidLine(INVALID_SPACE_LINE);
        // then
        assertFalse(actual);
    }

    @Test
    void isValidLineShouldReturnFalseForLineWithLetters() {
        // given
        // when
        boolean actual = validator.isValidLine(INVALID_LETTERS_LINE);
        // then
        assertFalse(actual);
    }

    @Test
    void isValidLineShouldReturnFalseForMixedInvalidLine() {
        // given
        // when
        boolean actual = validator.isValidLine(INVALID_MIXED_LINE);
        // then
        assertFalse(actual);
    }

    @Test
    void isValidLineShouldReturnFalseForEmptyLine() {
        // given
        // when
        boolean actual = validator.isValidLine(INVALID_EMPTY_LINE);
        // then
        assertFalse(actual);
    }

    @Test
    void isValidLineShouldReturnFalseForBlankLine() {
        // given
        // when
        boolean actual = validator.isValidLine(INVALID_BLANK_LINE);
        // then
        assertFalse(actual);
    }

    @Test
    void isValidLineShouldReturnFalseForDoubleCommaLine() {
        // given
        // when
        boolean actual = validator.isValidLine(INVALID_DOUBLE_COMMA_LINE);
        // then
        assertFalse(actual);
    }

    @Test
    void isValidLineShouldReturnFalseForTrailingCommaLine() {
        // given
        // when
        boolean actual = validator.isValidLine(INVALID_TRAILING_COMMA_LINE);
        // then
        assertFalse(actual);
    }

    @Test
    void isValidLineShouldReturnFalseForNullLine() {
        // given
        // when
        boolean actual = validator.isValidLine(null);
        // then
        assertFalse(actual);
    }
}
