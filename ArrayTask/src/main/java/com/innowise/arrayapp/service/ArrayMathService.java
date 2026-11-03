package com.innowise.arrayapp.service;

import com.innowise.arrayapp.entity.AbstractIntArrayEntity;
import java.util.Optional;

public interface ArrayMathService {

    Optional<Long> findSum(AbstractIntArrayEntity entity);

    Optional<Double> findAverage(AbstractIntArrayEntity entity);
}
