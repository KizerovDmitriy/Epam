package com.epam.rd.autotasks;

import java.util.Arrays;

public class GraduallyCarouselRun extends CarouselRun{

    private int [] counts = new int[container.getCarouselArray().length];
    public GraduallyCarouselRun(Container container) {
        super(container);
        Arrays.fill(counts, 1);
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
        if (container.getCarouselArray()[index] <= 0){
            valueBeforeChanged = 0;
            container.getCarouselArray()[index] = 0;
        }
        else {
            valueBeforeChanged = container.getCarouselArray()[index];
            container.getCarouselArray()[index] = container.getCarouselArray()[index] - counts[index]++;
            if (container.getCarouselArray()[index] < 0){
                container.getCarouselArray()[index] = 0;
            }
        }
        index++;
        return valueBeforeChanged;
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
