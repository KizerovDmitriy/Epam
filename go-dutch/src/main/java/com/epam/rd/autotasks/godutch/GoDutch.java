package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum;
        int billAmount = (int) (scanner.nextInt() * 1.1);
        int countFriends = scanner.nextInt();
        if (billAmount < 0){
            System.out.println("Bill total amount cannot be negative");
        }
        else if (countFriends <= 0){
            System.out.println("Number of friends cannot be negative or zero");
        } else  {
            sum = billAmount / countFriends;
            System.out.println(sum);
        }
    }
}
