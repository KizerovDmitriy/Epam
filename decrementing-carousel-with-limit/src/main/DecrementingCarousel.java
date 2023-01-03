package com.epam.rd.autotasks;

public class DecrementingCarousel {
    Container carouselArray;
    private boolean state = false;


    public DecrementingCarousel(int capacity) {
        this.carouselArray = new Container(capacity);
    }

    public boolean addElement(int element) {
        if (element > 0 && !isState()) {
            for (int i = 0; i < carouselArray.getCarouselArray().length; i++) {
                if (carouselArray.getCarouselArray()[i] == 0) {
                    carouselArray.getCarouselArray()[i] = element;
                    return true;
                }
            }
        }
        return false;
    }

    public CarouselRun run() {
        if (!isState()) {
            setState(true);
            return new CarouselRun(this.carouselArray);
        } else {
            return null;
        }
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
