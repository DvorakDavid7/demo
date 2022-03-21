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
                throw new InvalidArgumentException("invalid number");
            }
        }
        return result;
    }

    public static Integer convertToInteger(List<Integer> digitList) {
        StringBuilder result = new StringBuilder();

        for (Integer integer : digitList) {
            result.append(integer);
        }
        return Integer.parseInt(result.toString());
    }
}
