package com.epam.rd.autotasks;

import java.util.*;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = new ArrayList<>();

        while (true) {
            int i = scanner.nextInt();
            if (i != 0) {
                input.add(i);
            } else {
                break;
            }
        }
        int sum = 0;
        for (Integer i : input) {
            sum += i;
        }
        int middleValue = sum / input.size();
        System.out.println(middleValue);
    }
}