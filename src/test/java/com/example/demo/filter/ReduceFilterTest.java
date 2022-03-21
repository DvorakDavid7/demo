package com.example.demo.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReduceFilterTest {

    @Test
    void apply() {
        ReduceFilter reduceFilter = new ReduceFilter();
        List<Integer> data = Arrays.asList(4,5,3,2,6,7,1,8,1);
        List<Integer> result = reduceFilter.apply(data);
        Assertions.assertEquals(result, Arrays.asList(4,5,3,2,6,1,8,1));
    }
}
