package com.innowise.arrayapp.service;

import com.innowise.arrayapp.entity.AbstractIntArrayEntity;
import java.util.Optional;

public class IntArrayMathService implements ArrayMathService {

    @Override
    public Optional<Long> findSum(AbstractIntArrayEntity entity) {
        if (entity == null) {
            return Optional.empty();
        }
        int[] values = entity.getValues();
        if (values.length == 0) {
            return Optional.empty();
        }
        long sum = 0;
        for (int index = 0; index < values.length; index++) {
            sum += values[index];
        }
        return Optional.of(sum);
    }

    @Override
    public Optional<Double> findAverage(AbstractIntArrayEntity entity) {
        if (entity == null) {
            return Optional.empty();
        }
        int[] values = entity.getValues();
        if (values.length == 0) {
            return Optional.empty();
        }
        long sum = 0;
        for (int index = 0; index < values.length; index++) {
            sum += values[index];
        }
        double average = (double) sum / values.length;
        return Optional.of(average);
    }
}
