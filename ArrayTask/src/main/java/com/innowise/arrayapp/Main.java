package com.innowise.arrayapp;

import com.innowise.arrayapp.entity.AbstractIntArrayEntity;
import com.innowise.arrayapp.exception.ArrayDataException;
import com.innowise.arrayapp.factory.EntityFactory;
import com.innowise.arrayapp.factory.IntArrayEntityFactory;
import com.innowise.arrayapp.parser.IntArrayLineParser;
import com.innowise.arrayapp.parser.LineParser;
import com.innowise.arrayapp.reader.ArrayFileLineReader;
import com.innowise.arrayapp.reader.LineReader;
import com.innowise.arrayapp.service.ArrayMathService;
import com.innowise.arrayapp.service.ArraySearchService;
import com.innowise.arrayapp.service.ArraySortService;
import com.innowise.arrayapp.service.IntArrayMathService;
import com.innowise.arrayapp.service.IntArraySearchService;
import com.innowise.arrayapp.service.IntArraySortService;
import com.innowise.arrayapp.validator.ArrayLineValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String DATA_FILE_PATH = "data/arrays.txt";

    private final LineReader lineReader = new ArrayFileLineReader();
    private final ArrayLineValidator lineValidator = new ArrayLineValidator();
    private final LineParser lineParser = new IntArrayLineParser();
    private final EntityFactory entityFactory = new IntArrayEntityFactory();
    private final ArraySearchService searchService = new IntArraySearchService();
    private final ArrayMathService mathService = new IntArrayMathService();
    private final ArraySortService sortService = new IntArraySortService();

    public static void main(String[] args) {
        Main application = new Main();
        application.run();
    }

    private void run() {
        try {
            List<String> lines = lineReader.readLines(DATA_FILE_PATH);
            List<AbstractIntArrayEntity> entities = createEntities(lines);
            LOGGER.info("Created entities: " + entities.size());
            for (AbstractIntArrayEntity entity : entities) {
                logEntityResults(entity);
            }
        } catch (ArrayDataException e) {
            LOGGER.error("Application stopped: " + e.getMessage());
        }
    }

    private List<AbstractIntArrayEntity> createEntities(List<String> lines) {
        List<AbstractIntArrayEntity> entities = new ArrayList<>();
        for (String line : lines) {
            if (lineValidator.isValidLine(line)) {
                createEntity(line, entities);
            } else {
                LOGGER.warn("Invalid line skipped: \"" + line + "\"");
            }
        }
        return entities;
    }

    private void createEntity(String line, List<AbstractIntArrayEntity> entities) {
        try {
            int[] values = lineParser.parseLine(line);
            AbstractIntArrayEntity entity = entityFactory.createEntity(values);
            entities.add(entity);
        } catch (ArrayDataException e) {
            LOGGER.error("Entity was not created for line: " + e.getMessage());
        }
    }

    private void logEntityResults(AbstractIntArrayEntity entity) {
        Optional<Integer> minimum = searchService.findMin(entity);
        Optional<Integer> maximum = searchService.findMax(entity);
        Optional<Long> sum = mathService.findSum(entity);
        Optional<Double> average = mathService.findAverage(entity);
        int[] bubbleSortedValues = sortService.sortByBubble(entity);
        int[] insertionSortedValues = sortService.sortByInsertion(entity);
        LOGGER.info("Entity values: " + Arrays.toString(entity.getValues()));
        LOGGER.info("Min: " + minimum + ", max: " + maximum + ", sum: " + sum + ", average: " + average);
        LOGGER.info("Bubble sort result: " + Arrays.toString(bubbleSortedValues));
        LOGGER.info("Insertion sort result: " + Arrays.toString(insertionSortedValues));
    }
}
