package com.epam.rd.qa.classes;

public class ArrayRectangles {

    private final Rectangle[] rectangleArray;

    public ArrayRectangles(int size) {
        if (size > 0) {
            rectangleArray = new Rectangle[size];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public ArrayRectangles(Rectangle... rectangles) {
        if (rectangles != null && rectangles.length != 0) {
            rectangleArray = new Rectangle[rectangles.length];
            for (int i = 0; i < rectangles.length; i++) {
                if (rectangles[i] != null) {
                    this.rectangleArray[i] = rectangles[i];
                } else {
                    throw new IllegalArgumentException();
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean addRectangle(Rectangle rectangle) {
        boolean isTrue = false;
        int i = 0;
        while (i < rectangleArray.length) {
            if (rectangleArray[i] == null) {
                rectangleArray[i] = rectangle;
                i = rectangleArray.length;
                isTrue = true;
            }
            i++;
        }
        return isTrue;
    }

    public int size() {
        int count = 0;
        for (Rectangle rectangle : rectangleArray) {
            if (rectangle != null) {
                count++;
            }
        }
        if (count != rectangleArray.length) {
            return count;
        } else {
            return rectangleArray.length;
        }
    }

    public int indexMaxArea() {
        int index = 0;
        double[] perimeter = new double[rectangleArray.length];
        for (int i = 0; i < rectangleArray.length; i++) {
            perimeter[i] = 2 * (rectangleArray[i].getSideA() * rectangleArray[i].getSideB());
        }
        double max = perimeter[0];
        for (int i = 1; i < perimeter.length; i++) {
            if (max < perimeter[i]) {
                max = perimeter[i];
                index = i;
            }
        }
        return index;
    }

    public int indexMinPerimeter() {
        int index = 0;
        double[] perimeter = new double[rectangleArray.length];
        for (int i = 0; i < rectangleArray.length; i++) {
            perimeter[i] = 2 * (rectangleArray[i].getSideA() * rectangleArray[i].getSideB());
        }
        double min = perimeter[0];
        for (int i = 1; i < perimeter.length; i++) {
            if (min > perimeter[i]) {
                min = perimeter[i];
                index = i;
            }
        }
        return index;
    }

    public int numberSquares() {
        int countSquare = 0;
        for (Rectangle rectangle : rectangleArray) {
            if (rectangle.getSideA() == rectangle.getSideB()) {
                countSquare++;
            }
        }
        return countSquare;
    }
}