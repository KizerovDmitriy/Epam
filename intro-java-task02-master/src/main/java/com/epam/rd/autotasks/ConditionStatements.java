package com.epam.rd.autotasks;


import java.util.Arrays;
import java.util.Comparator;

class ConditionStatements {

    public static int task2(int n) {

        return Arrays.stream(Integer.toString(n).split(""))
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::parseInt)
                .reduce(0, (a, b) -> a * 10 + b);
    }
}
