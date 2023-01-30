package com.epam.rd.autotasks;


public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        long nShot = 1L << (63 - getIndexShot(shot));
        registerShot(nShot);
        return onTarget(ships, nShot);
    }

    public String state() {
        StringBuilder sb = new StringBuilder();
        long cursor = 1L << 63;
        for (int i = 0; i < 64; i++) {
            int shipResult = Long.bitCount(ships & cursor);
            int shotResult = Long.bitCount(shots & cursor);
            if (shipResult == 1 && shotResult == 1) {
                sb.append("☒");
            }
            if (shipResult == 1 && shotResult == 0) {
                sb.append("☐");
            }
            if (shipResult == 0 && shotResult == 1) {
                sb.append("×");
            }
            if (shipResult == 0 && shotResult == 0) {
                sb.append(".");
            }

            if (i == 7 || i == 15 || i == 23 || i == 31 || i == 39 || i == 47 || i == 55) {
                sb.append("\n");
            }
            cursor = cursor >>> 1;
        }
        return sb.toString().strip();
    }

    public void registerShot(long shot) {
        if (shots == 0L) {
            shots = shot;
        } else {
            shots = shots | shot;
        }
    }

    public int getIndexShot(String indexOfShot) {
        String[] parse = indexOfShot.split("");
        int index = Integer.parseInt(parse[1]);
        switch (parse[0]) {
            case ("A"):
                return --index * 8;
            case ("B"):
                return (--index * 8) + 1;
            case ("C"):
                return (--index * 8) + 2;
            case ("D"):
                return (--index * 8) + 3;
            case ("E"):
                return (--index * 8) + 4;
            case ("F"):
                return (--index * 8) + 5;
            case ("G"):
                return (--index * 8) + 6;
            case ("H"):
                return (--index * 8) + 7;
        }
        return 0;
    }

    public boolean onTarget(long target, long shotOnTarget) {
        return (target & shotOnTarget) == shotOnTarget;
    }
}