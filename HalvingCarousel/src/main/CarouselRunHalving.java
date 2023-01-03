package com.epam.rd.autotasks;

public class CarouselRunHalving extends CarouselRun{

    public CarouselRunHalving(Container container) {
        super(container);
    }

    @Override
    public int next() {
        int valueBeforeChanged;
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
        valueBeforeChanged = container.getCarouselArray()[index];
        container.getCarouselArray()[index] = container.getCarouselArray()[index] / 2;
        index++;
        return valueBeforeChanged;
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
