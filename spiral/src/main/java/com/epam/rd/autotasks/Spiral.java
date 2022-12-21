package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] result = new int[rows][columns];
        int i, k = 0, l = 0;
        int count = 1;
        while (k < rows && l < columns) {
            for (i = l; i < columns; ++i) {
                result[k][i] = count++;
            }
            k++;
            for (i = k; i < rows; ++i) {
                result[i][columns - 1] = count++;
            }
            columns--;

            if (k < rows) {
                for (i = columns - 1; i >= l; --i) {
                    result[rows - 1][i] = count++;
                }
                rows--;
            }

            if (l < columns) {
                for (i = rows - 1; i >= k; --i) {
                    result[i][l] = count++;
                }
                l++;
            }
        }
        return result;
    }
}