package com.innowise.arrayapp.parser;

import com.innowise.arrayapp.exception.ArrayDataException;

public interface LineParser {

    int[] parseLine(String line) throws ArrayDataException;
}
