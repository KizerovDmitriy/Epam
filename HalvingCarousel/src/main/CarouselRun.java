package com.epam.rd.autotasks;

public class CarouselRun {

    protected int index = 0;
    protected Container container;

    public int next() {
        if (isFinished()) {
            return -1;
        }
        if (index >= container.getCarouselArray().length) {
            index = 0;
        }
        while (container.getCarouselArray()[index] == 0) {
            index++;
            if (index >= container.getCarouselArray().length) {
                index = 0;
            }
        }
        return container.getCarouselArray()[index++]--;
    }

    public boolean isFinished() {
        for (int i : container.getCarouselArray()) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

    public CarouselRun(Container container) {
        this.container = container;
    }

}