package com.innowise.arrayapp.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.innowise.arrayapp.entity.AbstractIntArrayEntity;
import com.innowise.arrayapp.entity.IntArrayEntity;
import org.junit.jupiter.api.Test;

class IntArraySortServiceTest {

    private static final int[] UNSORTED_VALUES = {3, -7, 15, 0, 9};
    private static final int[] EXPECTED_SORTED_VALUES = {-7, 0, 3, 9, 15};
    private static final int[] DUPLICATES_VALUES = {2, 2, 1, 1};
    private static final int[] EXPECTED_DUPLICATES_SORTED = {1, 1, 2, 2};
    private static final int[] ALREADY_SORTED_VALUES = {1, 2, 3};
    private static final int[] EMPTY_ARRAY = {};

    private final ArraySortService sortService = new IntArraySortService();

    @Test
    void sortByBubbleShouldReturnSortedArray() {
        // given
        AbstractIntArrayEntity entity = new IntArrayEntity(UNSORTED_VALUES);
        // when
        int[] actual = sortService.sortByBubble(entity);
        // then
        assertArrayEquals(EXPECTED_SORTED_VALUES, actual);
    }

    @Test
    void sortByInsertionShouldReturnSortedArray() {
        // given
        AbstractIntArrayEntity entity = new IntArrayEntity(UNSORTED_VALUES);
        // when
        int[] actual = sortService.sortByInsertion(entity);
        // then
        assertArrayEquals(EXPECTED_SORTED_VALUES, actual);
    }

    @Test
    void sortByBubbleShouldHandleDuplicates() {
        // given
        AbstractIntArrayEntity entity = new IntArrayEntity(DUPLICATES_VALUES);
        // when
        int[] actual = sortService.sortByBubble(entity);
        // then
        assertArrayEquals(EXPECTED_DUPLICATES_SORTED, actual);
    }

    @Test
    void sortByInsertionShouldHandleAlreadySortedArray() {
        // given
        AbstractIntArrayEntity entity = new IntArrayEntity(ALREADY_SORTED_VALUES);
        // when
        int[] actual = sortService.sortByInsertion(entity);
        // then
        assertArrayEquals(ALREADY_SORTED_VALUES, actual);
    }

    @Test
    void sortByBubbleShouldReturnEmptyForEmptyArray() {
        // given
        AbstractIntArrayEntity entity = new IntArrayEntity(EMPTY_ARRAY);
        // when
        int[] actual = sortService.sortByBubble(entity);
        // then
        assertArrayEquals(EMPTY_ARRAY, actual);
    }

    @Test
    void sortByInsertionShouldReturnEmptyForNullEntity() {
        // given
        // when
        int[] actual = sortService.sortByInsertion(null);
        // then
        assertArrayEquals(EMPTY_ARRAY, actual);
    }

    @Test
    void sortByBubbleShouldNotChangeOriginalEntityValues() {
        // given
        AbstractIntArrayEntity entity = new IntArrayEntity(UNSORTED_VALUES);
        // when
        int[] sortedValues = sortService.sortByBubble(entity);
        // then
        int[] actualValues = entity.getValues();
        assertArrayEquals(UNSORTED_VALUES, actualValues);
        assertArrayEquals(EXPECTED_SORTED_VALUES, sortedValues);
    }
}
