package com.innowise.arrayapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.innowise.arrayapp.entity.AbstractIntArrayEntity;
import com.innowise.arrayapp.entity.IntArrayEntity;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class IntArraySearchServiceTest {

    private static final int[] SAMPLE_VALUES = {3, -7, 15, 0, 9};
    private static final int EXPECTED_MINIMUM = -7;
    private static final int EXPECTED_MAXIMUM = 15;
    private static final int[] SINGLE_VALUE_ARRAY = {42};
    private static final int EXPECTED_SINGLE_VALUE = 42;
    private static final int[] EMPTY_ARRAY = {};

    private final ArraySearchService searchService = new IntArraySearchService();

    @Test
    void findMinShouldReturnSmallestValue() {
        // given
        AbstractIntArrayEntity entity = new IntArrayEntity(SAMPLE_VALUES);
        // when
        Optional<Integer> actual = searchService.findMin(entity);
        // then
        assertEquals(Optional.of(EXPECTED_MINIMUM), actual);
    }

    @Test
    void findMaxShouldReturnLargestValue() {
        // given
        AbstractIntArrayEntity entity = new IntArrayEntity(SAMPLE_VALUES);
        // when
        Optional<Integer> actual = searchService.findMax(entity);
        // then
        assertEquals(Optional.of(EXPECTED_MAXIMUM), actual);
    }

    @Test
    void findMinShouldReturnValueForSingleElementArray() {
        // given
        AbstractIntArrayEntity entity = new IntArrayEntity(SINGLE_VALUE_ARRAY);
        // when
        Optional<Integer> actual = searchService.findMin(entity);
        // then
        assertEquals(Optional.of(EXPECTED_SINGLE_VALUE), actual);
    }

    @Test
    void findMaxShouldReturnEmptyForEmptyArray() {
        // given
        AbstractIntArrayEntity entity = new IntArrayEntity(EMPTY_ARRAY);
        // when
        Optional<Integer> actual = searchService.findMax(entity);
        // then
        assertEquals(Optional.empty(), actual);
    }

    @Test
    void findMinShouldReturnEmptyForNullEntity() {
        // given
        // when
        Optional<Integer> actual = searchService.findMin(null);
        // then
        assertEquals(Optional.empty(), actual);
    }
}
