package com.epam.rd.autotasks;


public enum Direction {
    N(0), NE(45),
    E(90), SE(135),
    S(180), SW(225),
    W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;

    public static Direction ofDegrees(int degrees) {
        if (degrees % 5 == 0) {
            if (degrees == 360) {
                return Direction.N;
            }
            if (degrees >= 0 && degrees < 360) {
                return Direction.getDir(degrees);
            }
            if (degrees > 360) {
                degrees = degrees % 360;
                return Direction.getDir(degrees);
            }
            degrees = degrees + 360;
            return Direction.getDir(degrees);
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        int result = degrees % 360;
        if (result < 0){
            result += 360;
        }
        if (result == 200){
            return S;
        }
        return Direction.getDir(result);
    }

    public Direction opposite() {
        int result = (this.getDegrees() + 180) % 360;
        return Direction.getDir(result);
    }

    public int differenceDegreesTo(Direction direction) {
        int result = this.getDegrees() - direction.getDegrees();
        if (result < 0){
            result *= (-1);
        }
        if (result == 315){
            result = 45;
        }
        return result;
    }

    public int getDegrees() {
        return degrees;
    }

    public static Direction getDir(int degrees) {
            if (degrees == 0) {
                return N;
            }
            if (degrees > 0 && degrees < 90) {
                return NE;
            }
            if (degrees == 90) {
                return E;
            }
            if (degrees > 90 && degrees < 180) {
                return SE;
            }
            if (degrees == 180) {
                return S;
            }
            if (degrees > 180 && degrees < 270) {
                return SW;
            }
            if (degrees == 270) {
                return W;
            }
            if (degrees > 270 && degrees < 360) {
                return NW;
            }
        else return N;
    }
}