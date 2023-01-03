package com.epam.rd.autotasks;

public class CarouselRunWithLimit extends CarouselRun {

    private int actionLimit;

    public CarouselRunWithLimit(Container container, int actionLimit) {
        super(container);
        this.actionLimit = actionLimit;
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
        container.getCarouselArray()[index]--;
        actionLimit--;
        index++;
        return valueBeforeChanged;
    }

    @Override
    public boolean isFinished() {
        if (actionLimit == 0) {
            return true;
        }
        for (int i : container.getCarouselArray()) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}