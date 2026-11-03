package com.innowise.arrayapp.service;

import com.innowise.arrayapp.entity.AbstractIntArrayEntity;
import java.util.Optional;

public interface ArraySearchService {

    Optional<Integer> findMin(AbstractIntArrayEntity entity);

    Optional<Integer> findMax(AbstractIntArrayEntity entity);
}
