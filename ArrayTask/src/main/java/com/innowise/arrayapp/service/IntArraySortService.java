package com.innowise.arrayapp.service;

import com.innowise.arrayapp.entity.AbstractIntArrayEntity;

public class IntArraySortService implements ArraySortService {

    @Override
    public int[] sortByBubble(AbstractIntArrayEntity entity) {
        if (entity == null) {
            return new int[0];
        }
        int[] result = entity.getValues();
        for (int outer = 0; outer < result.length - 1; outer++) {
            for (int inner = 0; inner < result.length - 1 - outer; inner++) {
                if (result[inner] > result[inner + 1]) {
                    int temporaryValue = result[inner];
                    result[inner] = result[inner + 1];
                    result[inner + 1] = temporaryValue;
                }
            }
        }
        return result;
    }

    @Override
    public int[] sortByInsertion(AbstractIntArrayEntity entity) {
        if (entity == null) {
            return new int[0];
        }
        int[] result = entity.getValues();
        for (int current = 1; current < result.length; current++) {
            int key = result[current];
            int previous = current - 1;
            while (previous >= 0 && result[previous] > key) {
                result[previous + 1] = result[previous];
                previous--;
            }
            result[previous + 1] = key;
        }
        return result;
    }
}
