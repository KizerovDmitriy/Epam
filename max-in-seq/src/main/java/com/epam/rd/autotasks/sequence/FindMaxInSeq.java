package com.epam.rd.autotasks.sequence;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = new ArrayList<>();

        while (true){
            int i =scanner.nextInt();
            if (i != 0){
                input.add(i);
            }
            else {
                break;
            }
        }
        return Collections.max(input);
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        System.out.println(max());
    }
}