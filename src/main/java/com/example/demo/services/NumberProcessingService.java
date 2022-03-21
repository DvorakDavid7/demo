package com.example.demo.services;

import com.example.demo.convertor.ConversionException;
import com.example.demo.filter.MoveFilter;
import com.example.demo.filter.MultiplyFilter;
import com.example.demo.filter.ReduceFilter;
import com.example.demo.convertor.DigitListConvertor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumberProcessingService {

    /**
     * Apply filters to given numberString
     * @param numberString String representation of input number
     * @return filtered number
     */
    public String processNumber(String numberString) throws NumberProcessingException {
        try {
            List<Integer> digitList = DigitListConvertor.convertToList(numberString);
            List<Integer> filteredNumbers = (new MoveFilter(new MultiplyFilter(new ReduceFilter())))
                    .apply(digitList);

            int numberOfEventDigits = countEvenDigits(filteredNumbers);
            int resultNumber = DigitListConvertor.convertToInteger(filteredNumbers);
            if (numberOfEventDigits != 0)
                resultNumber = (int) Math.floor(resultNumber / (double) numberOfEventDigits);
            return Integer.toString(resultNumber);

        } catch (ConversionException e) {
            throw new NumberProcessingException(e.getMessage());
        }
    }

    private Integer countEvenDigits(List<Integer> digitList) {
        int amount = 0;
        for (Integer digit : digitList) {
            if (digit % 2 == 0) {
                amount++;
            }
        }
        return amount;
    }
}
