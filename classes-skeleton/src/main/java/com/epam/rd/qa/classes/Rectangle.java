package com.epam.rd.qa.classes;

import java.util.Objects;

public class Rectangle {

    private double sideA;
    private double sideB;

    Rectangle(double sideA, double sideB) {
        if (sideA > 0 && sideB > 0) {
            this.sideA = sideA;
            this.sideB = sideB;
        } else {
            throw new IllegalArgumentException();
        }
    }

    Rectangle(double sideA) {
        if (sideA > 0) {
            this.sideA = sideA;
            this.sideB = this.sideA;
        } else {
            throw new IllegalArgumentException();
        }
    }

    Rectangle() {
        this.sideA = 4.0;
        this.sideB = 3.0;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double area() {
        if (this.sideA == this.sideB) {
            return this.sideA * this.sideA;
        } else {
            return this.sideA * this.sideB;
        }
    }

    public double perimeter() {
        if (this.sideA == this.sideB) {
            return 2 * (this.sideA + this.sideA);
        } else {
            return 2 * (this.sideA + this.sideB);
        }
    }

    public boolean isSquare() {
        return this.sideA == this.sideB;
    }

    public void replaceSides() {
        double tmp = this.sideA;
        this.sideA = this.sideB;
        this.sideB = tmp;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.sideA, sideA) == 0 && Double.compare(rectangle.sideB, sideB) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB);
    }
}
