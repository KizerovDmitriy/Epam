package com.epam.rd.autotasks;

public class CarouselRun {
    private static int index = 0;
    private int[] array = DecrementingCarousel.container.clone();

    public int next() {
        int count = 0;
        if (isFinished()) {
            index = 0;
            return -1;
        } else {
            while (count < array.length && array[index %= array.length] <= 0) {
                index++;
                count++;
            }
        }
        return array[index++]--;
    }

    public boolean isFinished() {
        for (int i : array) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}