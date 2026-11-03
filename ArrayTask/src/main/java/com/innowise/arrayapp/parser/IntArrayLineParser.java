package com.innowise.arrayapp.parser;

import com.innowise.arrayapp.exception.ArrayDataException;

public class IntArrayLineParser implements LineParser {

    private static final String COMMA_SEPARATOR_REGEX = ",";
    private static final String EMPTY_LINE_MESSAGE = "Line is empty or blank";
    private static final String INVALID_NUMBER_MESSAGE = "Invalid number token";

    @Override
    public int[] parseLine(String line) throws ArrayDataException {
        if (line == null || line.isBlank()) {
            throw new ArrayDataException(EMPTY_LINE_MESSAGE);
        }
        String trimmedLine = line.trim();
        String[] tokens = trimmedLine.split(COMMA_SEPARATOR_REGEX);
        int[] values = new int[tokens.length];
        for (int index = 0; index < tokens.length; index++) {
            values[index] = parseNumber(tokens[index], line);
        }
        return values;
    }

    private int parseNumber(String token, String sourceLine) throws ArrayDataException {
        try {
            String trimmedToken = token.trim();
            return Integer.parseInt(trimmedToken);
        } catch (NumberFormatException e) {
            throw new ArrayDataException(INVALID_NUMBER_MESSAGE + " \"" + token + "\" in line \"" + sourceLine + "\"", e);
        }
    }
}
