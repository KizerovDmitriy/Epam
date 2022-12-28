package com.epam.rd.autotasks;

public class DecrementingCarousel {
    static int[] container;
    private boolean state = false;


    public DecrementingCarousel(int capacity) {
        container = new int[capacity];
    }

    public boolean addElement(int element) {
        if (element > 0 && !isState()) {
            for (int i = 0; i < container.length; i++) {
                if (container[i] == 0) {
                    container[i] = element;
                    return true;
                }
            }
        }
        return false;
    }

    public CarouselRun run() {
        if (!isState()) {
            setState(true);
            return new CarouselRun();
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
