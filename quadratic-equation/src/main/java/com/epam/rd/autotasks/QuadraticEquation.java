package com.epam.rd.autotasks;

import java.util.Locale;
import java.util.Scanner;


public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double x1, x2;
        double discriminant = (Math.pow(b,2)) - (4 * a * c);

        if (discriminant > 0 && a != 0){
            x1 = (-1.0 * b + Math.sqrt(discriminant)) / (2 * a);
            x2 = (-1.0 * b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println(x1+" "+x2);
        } else if (discriminant == 0 && a != 0) {
            x1 = (-1.0 * b + Math.sqrt(discriminant)) / (2 * a);
            System.out.println(x1);
        }
        else {
            System.out.println("no roots");
        }
    }
}