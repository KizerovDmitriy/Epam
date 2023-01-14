package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        rectangleCreate();
    }

    @Override
    public Point centroid() {
        double x = ((a.getX() + b.getX() + c.getX()) / 3);
        double y = ((a.getY() + b.getY() + c.getY()) / 3);
        return new Point(x, y);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        return true;
    }

    private boolean rectangleExist() {
        return sideLength(a, b) + sideLength(a, c) > sideLength(b, c) &&
                sideLength(a, b) + sideLength(b, c) > sideLength(a, c) &&
                sideLength(b, c) + sideLength(a, c) > sideLength(a, b);
    }

    private boolean degeneracyReference() {
        return ((c.getX() - a.getX()) / (b.getX() - a.getX()) == (c.getY() - a.getY()) / (b.getY() - a.getY()));
    }

    private void rectangleCreate() {
        if (notNull() && rectangleExist() && !degeneracyReference() && area() != 0) {
            return;
        } else {
            throw new IllegalArgumentException();
        }
    }
    private boolean notNull() {
        return a != null && b != null && c != null;
    }
    public double area() {
        double p = (sideLength(a, b) + sideLength(a, c) + sideLength(b, c)) / 2;
        return Math.sqrt(p * (p - sideLength(a, b)) *
                (p - sideLength(a, c)) *
                (p - sideLength(b, c)));
    }
}