package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private Point pointCenter;
    private double diameter;

    public Circle(Point pointCenter, double diameter) {
        createCircle(pointCenter, diameter);
    }

    @Override
    public Point centroid() {
        return this.pointCenter;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        double delta = 1.0E-10;
        Circle circle;
        if (figure instanceof Circle) {
            circle = (Circle) figure;
        } else {
            return false;
        }
        return (Math.abs(circle.pointCenter.getX() - pointCenter.getX()) < delta) &&
                (Math.abs(circle.pointCenter.getY() - pointCenter.getY()) < delta) &&
                (Math.abs(circle.diameter - diameter)) < delta;
    }

    private void createCircle(Point pointCenter, double diameter) {
        if (pointCenter != null & diameter > 0) {
            this.pointCenter = pointCenter;
            this.diameter = diameter;
        } else {
            throw new IllegalArgumentException();
        }
    }
}