package com.example.demo.convertor;

import java.util.ArrayList;
import java.util.List;

public class DigitListConvertor {

    public static List<Integer> convertToList(String stringNumber) throws ConversionException {
        ArrayList<Integer> result = new ArrayList<>();
        for (char c : stringNumber.toCharArray()) {
            try {
                int num = Integer.parseInt(String.valueOf(c));
                result.add(num);
            } catch (NumberFormatException e) {
                throw new ConversionException("number contains invalid character");
            }
        }
        return result;
    }

    public static Integer convertToInteger(List<Integer> digitList) throws ConversionException {
        StringBuilder result = new StringBuilder();
        for (Integer integer : digitList) {
            result.append(integer);
        }
        try {
            return Integer.parseInt(result.toString());
        } catch (NumberFormatException e) {
            throw new ConversionException("cannot convert");
        }
    }
}
