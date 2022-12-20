package com.epam.rd.autotasks.meetautocode;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.TimeZone;


public class ElectronicWatch {

    private static final ZoneId UTC = ZoneId.of("UTC");
    private static final DateFormat UDF = new SimpleDateFormat("H:mm:ss");

    static {
        UDF.setTimeZone(TimeZone.getTimeZone(UTC));
    }

    private static void dateUTC() {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        final Date d = new Date(seconds * 1000L);
        System.out.println(UDF.format(d));
    }

    public static void main(String[] args) {
        dateUTC();
    }
}