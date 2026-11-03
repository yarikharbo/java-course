package com.innowise.arrayapp.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IntArrayEntityTest {

    private static final int[] SAMPLE_VALUES = {5, -2, 9};
    private static final int EXPECTED_SIZE = 3;
    private static final int MODIFIED_VALUE = 1000;

    @Test
    void sizeShouldReturnNumberOfValues() {
        // given
        IntArrayEntity entity = new IntArrayEntity(SAMPLE_VALUES);
        // when
        int actualSize = entity.size();
        // then
        assertEquals(EXPECTED_SIZE, actualSize);
    }

    @Test
    void getValuesShouldReturnDefensiveCopy() {
        // given
        IntArrayEntity entity = new IntArrayEntity(SAMPLE_VALUES);
        // when
        int[] returnedValues = entity.getValues();
        returnedValues[0] = MODIFIED_VALUE;
        int[] actualValues = entity.getValues();
        // then
        assertEquals(SAMPLE_VALUES[0], actualValues[0]);
    }

    @Test
    void entityShouldStoreEmptyArrayWhenValuesNull() {
        // given
        // when
        IntArrayEntity entity = new IntArrayEntity(null);
        // then
        assertEquals(0, entity.size());
    }
}
