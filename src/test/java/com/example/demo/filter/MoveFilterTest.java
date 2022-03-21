package com.example.demo.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoveFilterTest {

    @Test
    void apply() {
        MoveFilter moveFilter = new MoveFilter();
        List<Integer> data = Arrays.asList(4,3,2,5,6,7,9,1);
        List<Integer> result = moveFilter.apply(data);
        Assertions.assertEquals(result, Arrays.asList(4,5,3,2,6,7,9,1));
    }
}
