package pl.babol.adam;

import org.apache.commons.lang3.StringUtils;
import pl.babol.adam.exception.NegativesNotAllowedException;

public class Calculator {
    public int add(String numbers) {
        String defaultDelimeters = "[,\n]";
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        if (numbers.startsWith("//")) {
            String delimeter = StringUtils.substringBetween(numbers, "//", "\n");
            String numbersWithDelimiters = numbers.substring(2 + delimeter.length() + 1);
            return makeCalculations(numbersWithDelimiters.split(delimeter));

        } else {
            return makeCalculations(numbers.split(defaultDelimeters));
        }
    }

    private int makeCalculations(String[] result) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            int value = Integer.parseInt(result[i].trim());
            sum = sum + value;
            if (value < 0) {
                count++;
            }
        }
        if (count > 0) {
            throw new NegativesNotAllowedException("Negatives not allowed: " + count);
        }
        return sum;
    }
}

