package com.epam.rd.autotasks.figures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Quadrilateral extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        createQuadrilateral();
    }

    @Override
    public Point centroid() {
        Point center1 = new Triangle(a, b, c).centroid();
        Point center2 = new Triangle(a, c, d).centroid();
        Point center3 = new Triangle(a, b, d).centroid();
        Point center4 = new Triangle(b, d, c).centroid();
        return new Segment(center1, center2).intersection(new Segment(center3, center4));
    }

    @Override
    public boolean isTheSame(Figure figure) {
        Quadrilateral figure1;
        double x1 = 0;
        double x2 = 0;
        double y1 = 0;
        double y2 = 0;
        if (figure instanceof Quadrilateral) {
            figure1 = (Quadrilateral) figure;
            x1 = a.getX() + b.getX() + c.getX() + d.getX();
            x2 = figure1.a.getX() + figure1.b.getX() + figure1.c.getX() + figure1.d.getX();
            y1 = a.getY() + b.getY() + c.getY() + d.getY();
            y2 = figure1.a.getY() + figure1.b.getY() + figure1.c.getY() + figure1.d.getY();
        }

        return x1 == x2 && y1 == y2;
    }

    private void createQuadrilateral() {
        if (notNull() && area() != 0 && isConvex(returnArray(a, b, c, d)) && calcIsPointInside(a, b, c, d)) {
            return;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        double diagonal = sideLength(a, c);
        double p1 = (sideLength(a, b) + diagonal + sideLength(b, c)) / 2;
        double p2 = (sideLength(c, d) + diagonal + sideLength(d, a)) / 2;
        double square1 = Math.sqrt(p1 * (p1 - sideLength(a, b)) * (p1 - diagonal) * (p1 - sideLength(b, c)));
        double square2 = Math.sqrt(p2 * (p2 - sideLength(c, d)) * (p2 - diagonal) * (p2 - sideLength(d, a)));
        return square1 + square2;
    }

    private boolean notNull() {
        return a != null && b != null && c != null && d != null;
    }

    private double CrossProduct(double[][] A) {
        double X1 = (A[1][0] - A[0][0]);
        double Y1 = (A[1][1] - A[0][1]);
        double X2 = (A[2][0] - A[0][0]);
        double Y2 = (A[2][1] - A[0][1]);

        return (X1 * Y2 - Y1 * X2);
    }

    private boolean isConvex(double[][] points) {
        int N = points.length;
        double prev = 0;
        double curr;
        for (int i = 0; i < N; i++) {
            double[][] temp = {points[i],
                    points[(i + 1) % N],
                    points[(i + 2) % N]};
            curr = CrossProduct(temp);
            if (curr != 0) {
                if (curr * prev < 0) {
                    return false;
                } else {
                    prev = curr;
                }
            }
        }
        return true;
    }

    private double[][] returnArray(Point a, Point b, Point c, Point d) {
        return new double[][]{{a.getX(), a.getY()}, {b.getX(), b.getY()}, {c.getX(), c.getY()}, {d.getX(), d.getY()}};
    }

    private boolean degeneracy(Point a, Point b, Point c, Point d) {
        List<Point> points = new ArrayList<>();
        points.add(a);
        points.add(b);
        points.add(c);
        points.add(d);
        Iterator<Point> iter = points.iterator();
        while (iter.hasNext()) {
            Point p = iter.next();
            iter.remove();
            if (points.contains(p)) {
                return false;
            }
        }
        return true;
    }

    private boolean calcIsPointInside(Point p1, Point p2, Point p3, Point p4) {

        Triangle tr;
        double s1, s2, s3, s4, delta;

        tr = new Triangle(p1, p2, p3);
        s1 = tr.area(p1, p2, p3);

        tr = new Triangle(p1, p2, p4);
        s2 = tr.area(p1, p2, p4);
        tr = new Triangle(p1, p3, p4);
        s3 = tr.area(p1, p3, p4);
        tr = new Triangle(p2, p3, p4);
        s4 = tr.area(p2, p3, p4);

        delta = 0.0001;

        if (Math.abs(s1 - (s2 + s3 + s4)) < delta) {
            return true;
        } else {
            return degeneracy(a, b, c, d);
        }
    }
}