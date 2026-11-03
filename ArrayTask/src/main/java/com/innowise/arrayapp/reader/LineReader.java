package com.innowise.arrayapp.reader;

import com.innowise.arrayapp.exception.ArrayDataException;
import java.util.List;

public interface LineReader {

    List<String> readLines(String filePath) throws ArrayDataException;
}
