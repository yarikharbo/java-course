package com.innowise.arrayapp.factory;

import com.innowise.arrayapp.entity.AbstractIntArrayEntity;
import com.innowise.arrayapp.entity.IntArrayEntityBuilder;

public class IntArrayEntityFactory implements EntityFactory {

    @Override
    public AbstractIntArrayEntity createEntity(int[] values) {
        IntArrayEntityBuilder builder = new IntArrayEntityBuilder();
        builder.values(values);
        return builder.build();
    }
}
