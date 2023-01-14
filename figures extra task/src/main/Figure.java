package com.epam.rd.autotasks.figures;

abstract class Figure {

    public abstract Point centroid();

    public abstract boolean isTheSame(Figure figure);

    public double sideLength(Point a, Point b) {
        return Math.sqrt((Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2)));
    }
    public double area(Point a, Point b, Point c) {
        double p = (sideLength(a, b) + sideLength(a, c) + sideLength(b, c)) / 2;
        return Math.sqrt(p * (p - sideLength(a, b)) *
                (p - sideLength(a, c)) *
                (p - sideLength(b, c)));
    }
}