package com.epam.rd.autotasks.figures;

class Triangle extends Figure {

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        if (rectangleExist(a, b, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    @Override
    public double area() {
        double p = (sideLength(a, b) + sideLength(a, c) + sideLength(b, c)) / 2;
        return Math.sqrt(p * (p - sideLength(a, b)) *
                        (p - sideLength(a, c)) *
                        (p - sideLength(b, c)));
    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString();
    }

    @Override
    public Point leftmostPoint() {
        double max = Integer.MAX_VALUE;
        Point left = null;
        Point[] points = {a, b, c};
        for (Point point : points) {
            if (point.getX() < max) {
                max = point.getX();
                left = point;
            }
        }
        return left;
    }

    private boolean rectangleExist(Point a, Point b, Point c) {
        return sideLength(a, b) + sideLength(a, c) > sideLength(b, c) &&
                sideLength(a, b) + sideLength(b, c) > sideLength(a, c) &&
                sideLength(b, c) + sideLength(a, c) > sideLength(a, b);
    }
}