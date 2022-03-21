package com.example.demo.filter;

import com.example.demo.utils.DigitListConvertor;
import com.example.demo.utils.InvalidArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Multiply each number equal to one of the targets by multiplier
 */
public class MultiplyFilter implements Filter {

    private final Logger log = LoggerFactory.getLogger(MultiplyFilter.class);

    /**
     * set of the target values which will be multiplied by multiplier
     */
    private static final Set<Integer> targets = Set.of(8, 9);
    private static final int multiplier = 2;
    private Filter nextFilter;

    public MultiplyFilter() {
    }

    public MultiplyFilter(Filter nextFilter) {
        this.nextFilter = nextFilter;
    }

    @Override
    public List<Integer> apply(List<Integer> numbers) {
        ArrayList<Integer> result = new ArrayList<>();
        log.info("applying MultiplyFilter");
        for (Integer digit : numbers) {
            if (targets.contains(digit)) {
                int dbl = digit * multiplier;
                String stringNumber = Integer.toString(dbl);
                try {
                    result.addAll(DigitListConvertor.convertToList(stringNumber));
                } catch (InvalidArgumentException e) {
                    log.error("invalid digit in number list: " + numbers);
                    return null;
                }
            } else {
                result.add(digit);
            }
        }
        if (nextFilter != null)
            return nextFilter.apply(result);
        return result;
    }
}
