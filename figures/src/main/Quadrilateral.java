package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {

    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        double diagonal = sideLength(a, c);
        double p1 = (sideLength(a, b) + diagonal + sideLength(b, c)) / 2;
        double p2 = (sideLength(c, d) + diagonal + sideLength(d, a)) / 2;
        double square1 = Math.sqrt(p1 * (p1 - sideLength(a, b)) * (p1 - diagonal) * (p1 - sideLength(b, c)));
        double square2 = Math.sqrt(p2 * (p2 - sideLength(c, d)) * (p2 - diagonal) * (p2 - sideLength(d, a)));
        return square1 + square2;
    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString() + d.toString();
    }

    @Override
    public Point leftmostPoint() {
        double max = Integer.MAX_VALUE;
        Point left = null;
        Point[] points = {a, b, c, d};
        for (Point point : points) {
            if (point.getX() < max) {
                max = point.getX();
                left = point;
            }
        }
        return left;
    }
}