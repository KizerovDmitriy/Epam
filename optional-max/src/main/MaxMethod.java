package com.epam.rd.autotasks.max;

import java.util.*;
import java.util.stream.Collectors;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        return elements(values);
    }

    private static OptionalInt elements(int[] array) {
        OptionalInt result;
        if (array != null && array.length != 0) {
            int sum = sumOfElements(array);
            result = OptionalInt.of(sum);
        } else {
            return OptionalInt.empty();
        }
        return result;
    }

    public static int sumOfElements(int[] array) {
        List<Integer> result = Arrays.stream(array).boxed().collect(Collectors.toList());
        return Collections.max(result);
    }
}