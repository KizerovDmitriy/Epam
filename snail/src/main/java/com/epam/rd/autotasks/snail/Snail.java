package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int h = scanner.nextInt();
        int result = 0;
        int count = 0;
        if (a <= b && a < h) {
            System.out.println("Impossible");
        } else {
            while (true) {
                result += a;
                count++;
                if (result < h) {
                    result -= b;
                } else {
                    break;
                }
            }
            System.out.println(count);
        }
    }
}