package com.example.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Moves each digit less than or equal to targetBound one position to the right
 */
public class MoveFilter implements Filter {
    private final Logger log = LoggerFactory.getLogger(MoveFilter.class);

    /**
     * every number less than or equal to will be moved to the right
     */
    private static final int targetBound = 3;

    private Filter nextFilter;

    public MoveFilter() {
    }

    public MoveFilter(Filter nextFilter) {
        this.nextFilter = nextFilter;
    }


    @Override
    public List<Integer> apply(List<Integer> numbers) {
        log.info("applying MoveFilter");
        List<Integer> result = new ArrayList<>(numbers);

        for (int i = result.size() - 1; i > 0; i--) {
            if (result.get(i - 1) <= targetBound) {
                Collections.swap(result, i, i - 1);
            }
        }

        if (nextFilter != null) {
            return nextFilter.apply(result);
        }
        return result;
    }
}
