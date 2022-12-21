package com.epam.rd.autotasks.meetstrangers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countQuest;
        countQuest = Integer.parseInt(reader.readLine());
        if (countQuest == 0) {
            System.out.println("Oh, it looks like there is no one here");
        } else if (countQuest < 0) {
            System.out.println("Seriously? Why so negative?");
        } else {
            String[] questArray = new String[countQuest];
            for (int i = 0; i < countQuest; i++) {
                String name = reader.readLine();
                questArray[i] = name;
            }
            for (int i = 0; i < countQuest; i++) {
                System.out.println("Hello, " + questArray[i]);
            }
            reader.close();
        }
    }
}