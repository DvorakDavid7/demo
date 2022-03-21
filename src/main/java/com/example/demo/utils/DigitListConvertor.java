package com.example.demo.utils;

import java.util.ArrayList;
import java.util.List;

public class DigitListConvertor {

    public static List<Integer> convertToList(String stringNumber) throws InvalidArgumentException {
        ArrayList<Integer> result = new ArrayList<>();
        for (char c : stringNumber.toCharArray()) {
            try {
                int num = Integer.parseInt(String.valueOf(c));
                result.add(num);
            } catch (NumberFormatException e) {
                throw new InvalidArgumentException("number contains invalid character");
            }
        }
        return result;
    }

    public static Integer convertToInteger(List<Integer> digitList) throws InvalidArgumentException {
        StringBuilder result = new StringBuilder();

        for (Integer integer : digitList) {
            result.append(integer);
        }
        try {
            return Integer.parseInt(result.toString());
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException("cannot convert");
        }
    }
}
