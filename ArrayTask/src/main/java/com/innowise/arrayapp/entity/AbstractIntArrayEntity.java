package com.innowise.arrayapp.entity;

import java.util.Arrays;

public abstract class AbstractIntArrayEntity {

    private final int[] values;

    protected AbstractIntArrayEntity(int[] values) {
        if (values != null) {
            this.values = values.clone();
        } else {
            this.values = new int[0];
        }
    }

    public int[] getValues() {
        return values.clone();
    }

    public int size() {
        return values.length;
    }

    @Override
    public String toString() {
        return "IntArrayEntity{values=" + Arrays.toString(values) + "}";
    }
}
