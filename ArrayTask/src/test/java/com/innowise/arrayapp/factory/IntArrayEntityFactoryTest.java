package com.innowise.arrayapp.factory;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.innowise.arrayapp.entity.AbstractIntArrayEntity;
import com.innowise.arrayapp.entity.IntArrayEntity;
import org.junit.jupiter.api.Test;

class IntArrayEntityFactoryTest {

    private static final int[] SAMPLE_VALUES = {3, 14, 15};

    private final EntityFactory entityFactory = new IntArrayEntityFactory();

    @Test
    void createEntityShouldReturnEntityWithProvidedValues() {
        // given
        // when
        AbstractIntArrayEntity entity = entityFactory.createEntity(SAMPLE_VALUES);
        // then
        assertArrayEquals(SAMPLE_VALUES, entity.getValues());
        assertTrue(entity instanceof IntArrayEntity);
    }

    @Test
    void createEntityShouldReturnEmptyEntityForNullValues() {
        // given
        // when
        AbstractIntArrayEntity entity = entityFactory.createEntity(null);
        // then
        assertEquals(0, entity.size());
    }
}
