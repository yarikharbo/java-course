package com.innowise.arrayapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.innowise.arrayapp.entity.AbstractIntArrayEntity;
import com.innowise.arrayapp.entity.IntArrayEntity;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class IntArrayMathServiceTest {

    private static final int[] SAMPLE_VALUES = {3, -7, 15, 0, 9};
    private static final long EXPECTED_SUM = 20L;
    private static final double EXPECTED_AVERAGE = 4.0;
    private static final int[] EMPTY_ARRAY = {};

    private final ArrayMathService mathService = new IntArrayMathService();

    @Test
    void findSumShouldReturnSumOfValues() {
        // given
        AbstractIntArrayEntity entity = new IntArrayEntity(SAMPLE_VALUES);
        // when
        Optional<Long> actual = mathService.findSum(entity);
        // then
        assertEquals(Optional.of(EXPECTED_SUM), actual);
    }

    @Test
    void findAverageShouldReturnAverageOfValues() {
        // given
        AbstractIntArrayEntity entity = new IntArrayEntity(SAMPLE_VALUES);
        // when
        Optional<Double> actual = mathService.findAverage(entity);
        // then
        assertEquals(Optional.of(EXPECTED_AVERAGE), actual);
    }

    @Test
    void findSumShouldReturnEmptyForEmptyArray() {
        // given
        AbstractIntArrayEntity entity = new IntArrayEntity(EMPTY_ARRAY);
        // when
        Optional<Long> actual = mathService.findSum(entity);
        // then
        assertEquals(Optional.empty(), actual);
    }

    @Test
    void findAverageShouldReturnEmptyForNullEntity() {
        // given
        // when
        Optional<Double> actual = mathService.findAverage(null);
        // then
        assertEquals(Optional.empty(), actual);
    }
}
