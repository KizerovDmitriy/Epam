package com.epam.rd.autocode.floodfill;

import java.util.ArrayList;
import java.util.List;

public class FloodLoggerImp implements FloodLogger {
    List<String> loggerList = new ArrayList<>();
    @Override
    public void log(String floodState) {
        loggerList.add(floodState);
    }
}