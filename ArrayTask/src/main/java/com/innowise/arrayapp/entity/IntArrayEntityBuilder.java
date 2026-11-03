package com.innowise.arrayapp.entity;

public class IntArrayEntityBuilder {

    private int[] values = new int[0];

    public IntArrayEntityBuilder values(int[] sourceValues) {
        if (sourceValues != null) {
            this.values = sourceValues.clone();
        } else {
            this.values = new int[0];
        }
        return this;
    }

    public IntArrayEntity build() {
        return new IntArrayEntity(this.values);
    }
}
