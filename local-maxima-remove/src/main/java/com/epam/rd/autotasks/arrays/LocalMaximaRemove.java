package com.epam.rd.autotasks.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if ((i > 0 && array[i] <= array[i - 1]) ||
                    (i != array.length - 1 && array[i] <= array[i + 1])) {
                res.add(array[i]);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}