package com.innowise.arrayapp.service;

import com.innowise.arrayapp.entity.AbstractIntArrayEntity;

public interface ArraySortService {

    int[] sortByBubble(AbstractIntArrayEntity entity);

    int[] sortByInsertion(AbstractIntArrayEntity entity);
}
