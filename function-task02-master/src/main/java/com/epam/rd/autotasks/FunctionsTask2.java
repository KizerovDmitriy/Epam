package com.epam.rd.autotasks;

public class FunctionsTask2 {
    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     * if set invalid arguments in method, then method must throws
     * IllegalArgumentException
     */
    public static boolean isSorted(int[] array, SortOrder order) {
        boolean isTrue = true;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]){
                isTrue = false;
            }
        }
        return isTrue;
    }
    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     * if set invalid arguments in method, then method must throws
     * IllegalArgumentException
     */
    public static int[] transform(int[] array, SortOrder order) {
        for (int i = 0; i < array.length; i++) {
            array[i] += i;
        }
       return array;
    }
}
