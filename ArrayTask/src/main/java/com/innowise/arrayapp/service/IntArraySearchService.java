package com.innowise.arrayapp.service;

import com.innowise.arrayapp.entity.AbstractIntArrayEntity;
import java.util.Optional;

public class IntArraySearchService implements ArraySearchService {

    @Override
    public Optional<Integer> findMin(AbstractIntArrayEntity entity) {
        if (entity == null) {
            return Optional.empty();
        }
        int[] values = entity.getValues();
        if (values.length == 0) {
            return Optional.empty();
        }
        int minimum = values[0];
        for (int index = 1; index < values.length; index++) {
            if (values[index] < minimum) {
                minimum = values[index];
            }
        }
        return Optional.of(minimum);
    }

    @Override
    public Optional<Integer> findMax(AbstractIntArrayEntity entity) {
        if (entity == null) {
            return Optional.empty();
        }
        int[] values = entity.getValues();
        if (values.length == 0) {
            return Optional.empty();
        }
        int maximum = values[0];
        for (int index = 1; index < values.length; index++) {
            if (values[index] > maximum) {
                maximum = values[index];
            }
        }
        return Optional.of(maximum);
    }
}
