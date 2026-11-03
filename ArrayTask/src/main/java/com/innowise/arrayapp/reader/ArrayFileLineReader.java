package com.innowise.arrayapp.reader;

import com.innowise.arrayapp.exception.ArrayDataException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayFileLineReader implements LineReader {

    private static final Logger LOGGER = LogManager.getLogger(ArrayFileLineReader.class);

    @Override
    public List<String> readLines(String filePath) throws ArrayDataException {
        try {
            Path path = Paths.get(filePath);
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.error("Failed to read data file: " + filePath);
            throw new ArrayDataException("Failed to read data file: " + filePath, e);
        }
    }
}
