package com.innowise.arrayapp.factory;

import com.innowise.arrayapp.entity.AbstractIntArrayEntity;

public interface EntityFactory {

    AbstractIntArrayEntity createEntity(int[] values);
}
