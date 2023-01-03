package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public CarouselRun run() {
        if (!isState()) {
            setState(true);
            return new GraduallyCarouselRun(this.carouselArray);
        } else {
            return null;
        }
    }

    @Override
    public boolean addElement(int element) {
        return super.addElement(element);
    }
}
