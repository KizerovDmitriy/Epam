package com.epam.rd.autotasks;


class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array != null && array.length != 0) {
            for (int i = array.length - 1; i > 0; i--) {
                int tmp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = tmp;
            }
        }
    }

    static void cycleSwap(int[] array, int shift) {
        if (array != null && array.length != 0) {
            for (int i = 0; i < shift; i++) {
                int temp = array[array.length - 1];
                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = temp;
            }
        }
    }
}