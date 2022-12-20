package com.epam.rd.autotasks;


class FunctionsTask1 {
    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     * if set invalid arguments in method, then method must throws
     * IllegalArgumentException
     */
    public static boolean isSorted(int[] array, SortOrder order) {

        boolean isTrue = true;

        if (order == null) {
            throw new IllegalArgumentException();
        } else {

            switch (order) {
                case ASC:
                    if (array.length == 0 || array == null) {
                        throw new IllegalArgumentException();
                    } else {
                        for (int i = 0; i < array.length - 1; i++) {
                            if (array[i] > array[i + 1]) {
                                isTrue = false;
                            }
                        }
                    }
                    break;
                case DESC:
                    if (array.length == 0 || array == null) {
                        throw new IllegalArgumentException();
                    } else {
                        for (int i = 0; i < array.length - 1; i++) {
                            if (array[i] < array[i + 1]) {
                                isTrue = false;
                            }
                        }
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return isTrue;
    }
}