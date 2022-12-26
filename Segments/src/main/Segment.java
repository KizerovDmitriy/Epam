package com.epam.rd.autotasks.segments;


class Segment {

    private Point start;
    private Point end;

    public Segment(Point start, Point end) {
        if (start.getX() != end.getX() || start.getY() != end.getY()) {
            this.start = start;
            this.end = end;
        } else {
            throw new IllegalArgumentException();
        }

    }

    double length() {
        return Math.sqrt((Math.pow((end.getX() - start.getX()), 2)) + (Math.pow((end.getY() - start.getY()), 2)));
    }

    Point middle() {
        return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }

    Point intersection(Segment another) {

        if (checkIntersectionOfTwoLineSegments(this.start, this.end, another.start, another.end)) {

            double u = ((another.end.getX() - another.start.getX()) * (this.start.getY() - another.start.getY()) -
                    (another.end.getY() - another.start.getY()) * (this.start.getX() - another.start.getX())) /
                    ((another.end.getY() - another.start.getY()) * (this.end.getX() - this.start.getX()) -
                            (another.end.getX() - another.start.getX()) * (this.end.getY() - this.start.getY()));


            double x = this.start.getX() + u * (this.end.getX() - this.start.getX());

            double y = this.start.getY() + u * (this.end.getY() - this.start.getY());

            return new Point(x, y);

        } else {
            return null;
        }
    }

    private boolean checkIntersectionOfTwoLineSegments(Point p1, Point p2,
                                                       Point p3, Point p4) {

        if (p2.getX() < p1.getX()) {

            Point tmp = p1;
            p1 = p2;
            p2 = tmp;
        }

        if (p4.getX() < p3.getX()) {

            Point tmp = p3;
            p3 = p4;
            p4 = tmp;
        }

        if (p2.getX() < p3.getX()) {
            return false;
        }

        if ((p1.getX() - p2.getX() == 0) && (p3.getX() - p4.getX() == 0)) {


            if (p1.getX() == p3.getX()) {


                if (!((Math.max(p1.getY(), p2.getY()) < Math.min(p3.getY(), p4.getY())) ||
                        (Math.min(p1.getY(), p2.getY()) > Math.max(p3.getY(), p4.getY())))) {

                    return true;
                }
            }

            return false;
        }

        if (p1.getX() - p2.getX() == 0) {

            double Xa = p1.getX();
            double A2 = (p3.getY() - p4.getY()) / (p3.getX() - p4.getX());
            double b2 = p3.getY() - A2 * p3.getX();
            double Ya = A2 * Xa + b2;

            if (p3.getX() <= Xa && p4.getX() >= Xa && Math.min(p1.getY(), p2.getY()) <= Ya &&
                    Math.max(p1.getY(), p2.getY()) >= Ya) {

                return true;
            }

            return false;
        }

        if (p3.getX() - p4.getX() == 0) {

            double Xa = p3.getX();
            double A1 = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
            double b1 = p1.getY() - A1 * p1.getX();
            double Ya = A1 * Xa + b1;

            if (p1.getX() <= Xa && p2.getX() >= Xa && Math.min(p3.getY(), p4.getY()) <= Ya &&
                    Math.max(p3.getY(), p4.getY()) >= Ya) {

                return true;
            }

            return false;
        }

        double A1 = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
        double A2 = (p3.getY() - p4.getY()) / (p3.getX() - p4.getX());
        double b1 = p1.getY() - A1 * p1.getX();
        double b2 = p3.getY() - A2 * p3.getX();

        if (A1 == A2) {
            return false;
        }

        double Xa = (b2 - b1) / (A1 - A2);

        if ((Xa < Math.max(p1.getX(), p3.getX())) || (Xa > Math.min(p2.getX(), p4.getX()))) {
            return false;
        } else {
            return true;
        }
    }
}