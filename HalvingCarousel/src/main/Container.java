package com.epam.rd.autotasks;

public class Container {
    private int[] carouselArray;

    public Container(int size) {
        this.carouselArray = new int[size];
    }

    public int[] getCarouselArray() {
        return carouselArray;
    }
}
