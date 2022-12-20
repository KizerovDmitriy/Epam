package com.epam.rd.autotasks;


class LoopStatements {
    public static int sumOddDigits(int n) {
        String [] numbers=Integer.toString(n).split("");
        int result=0;
        for (String number : numbers) {
            if (Integer.parseInt(number) % 2 != 0) {
                result += Integer.parseInt(number);
            }
        }
        return result;
    }




}
