package com.epam.rd.autocode.floodfill;


public class FloodFillImpl implements FloodFill {

    @Override
    public void flood(String map, FloodLogger logger) {
        logger.log(map);
        if (isFull(map)) {
            String[][] result = convertTo2DArray(map);
            checkFlood(result);
            map = arrayToString(result);
            flood(map, logger);
        }
    }

    public boolean isFull(String map) {
        return map.contains(String.valueOf(FloodFill.LAND));
    }

    public void checkFlood(String[][] map) {
        String[][] tmp = copyArray(map);
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                if (tmp[i][j].equals(String.valueOf(FloodFill.WATER))) {
                    if ((j - 1) >= 0 && (j - 1) <= (tmp[0].length - 1)) {
                        map[i][j - 1] = String.valueOf(FloodFill.WATER);
                    }
                    if ((j + 1) <= (tmp[0].length - 1)) {
                        map[i][j + 1] = String.valueOf(FloodFill.WATER);
                    }
                    if ((i - 1) >= 0 && (i - 1) <= (tmp.length - 1)) {
                        map[i - 1][j] = String.valueOf(FloodFill.WATER);
                    }
                    if ((i + 1) <= (tmp.length - 1)) {
                        map[i + 1][j] = String.valueOf(FloodFill.WATER);
                    }
                }
            }
        }
    }

    public String[][] convertTo2DArray(String str) {
        int countRows = 1;
        int countColum = 0;
        String[] tmp = str.split("");
        for (String s : tmp) {
            if (s.equals("\n")) {
                countRows++;
                countColum = 0;
            } else countColum++;
        }
        String[][] result = new String[countRows][countColum];
        countRows = 0;
        countColum = 0;
        for (String s : tmp) {
            if (s.equals("\n")) {
                countRows++;
                countColum = 0;
            } else {
                result[countRows][countColum++] = s;
            }
        }
        return result;
    }

    public String arrayToString(String[][] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (j == array[0].length - 1 && i != array.length - 1) {
                    sb.append(array[i][j]);
                    sb.append("\n");
                } else {
                    sb.append(array[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public String[][] copyArray(String[][] array) {
        String[][] result = new String[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(array[i], 0, result[i], 0, array[0].length);
        }
        return result;
    }
}