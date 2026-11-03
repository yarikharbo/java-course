package com.innowise.arrayapp.entity;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IntArrayEntityBuilderTest {

    private static final int[] SAMPLE_VALUES = {4, 8, 15, 16};

    @Test
    void buildShouldCreateEntityWithProvidedValues() {
        // given
        IntArrayEntityBuilder builder = new IntArrayEntityBuilder();
        builder.values(SAMPLE_VALUES);
        // when
        IntArrayEntity entity = builder.build();
        // then
        assertArrayEquals(SAMPLE_VALUES, entity.getValues());
    }

    @Test
    void buildShouldCreateEmptyEntityWhenValuesNotSet() {
        // given
        IntArrayEntityBuilder builder = new IntArrayEntityBuilder();
        // when
        IntArrayEntity entity = builder.build();
        // then
        assertEquals(0, entity.size());
    }

    @Test
    void buildShouldCreateEmptyEntityWhenValuesNull() {
        // given
        IntArrayEntityBuilder builder = new IntArrayEntityBuilder();
        builder.values(null);
        // when
        IntArrayEntity entity = builder.build();
        // then
        assertEquals(0, entity.size());
    }
}
