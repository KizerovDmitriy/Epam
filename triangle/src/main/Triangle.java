package com.epam.rd.autotasks.triangle;

class Triangle {

    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        if (rectangleExist(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else throw new IllegalArgumentException();
    }

    public double area() {
        double p = (sideLength(a, b) + sideLength(a, c) + sideLength(b, c)) / 2;
        return Math.sqrt(p * (p - sideLength(a, b)) * (p - sideLength(a, c)) * (p - sideLength(b, c)));
    }

    public Point centroid() {
        return new Point(((this.a.getX() + this.b.getX() + this.c.getX()) / 3), ((this.a.getY() + this.b.getY() + this.c.getY()) / 3));
    }

    private double sideLength(Point a, Point b) {
        return Math.sqrt((Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2)));
    }

    private boolean rectangleExist(Point a, Point b, Point c) {
        return sideLength(a, b) + sideLength(a, c) > sideLength(b, c) &&
                sideLength(a, b) + sideLength(b, c) > sideLength(a, c) &&
                sideLength(b, c) + sideLength(a, c) > sideLength(a, b);
    }
}