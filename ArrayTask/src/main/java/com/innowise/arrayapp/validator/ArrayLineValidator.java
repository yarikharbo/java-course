package com.innowise.arrayapp.validator;

public class ArrayLineValidator {

    private static final String COMMA_SEPARATED_INT_REGEX = "\\s*-?\\d+\\s*(,\\s*-?\\d+\\s*)*";

    public boolean isValidLine(String line) {
        if (line == null) {
            return false;
        }
        return line.trim().matches(COMMA_SEPARATED_INT_REGEX);
    }
}
