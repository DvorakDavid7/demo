package com.example.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Removes target digits from given number
 */
public class ReduceFilter implements Filter {
    private final Logger log = LoggerFactory.getLogger(MultiplyFilter.class);

    /**
     * value which will be removed from number
     */
    static private final int target = 7;

    private Filter nextFilter;

    public ReduceFilter() {
    }

    public ReduceFilter(Filter nextFilter) {
        this.nextFilter = nextFilter;
    }

    @Override
    public List<Integer> apply(List<Integer> numbers) {
        // log.info("applying ReduceFilter");

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer digit : numbers) {
            if (!Objects.equals(digit, target)) {
                result.add(digit);
            }
        }
        if (nextFilter != null)
            return nextFilter.apply(result);
        return result;
    }
}
