package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {


    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public boolean addElement(int element) {
        return super.addElement(element);
    }

    @Override
    public CarouselRun run() {
        if (!isState()) {
            setState(true);
            return new CarouselRunHalving(this.carouselArray);
        } else {
            return null;
        }
    }

}
