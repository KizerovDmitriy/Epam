package com.epam.rd.autotasks;


class LoopStatements {
    public static int sumOfFibonacciNumbers(int n) {
        int [] fibo=new int[n+1];
        int sum = 0;
        for (int i=0; i<n; i++)
        {
            if (i==0 || i==1){
                fibo[i]=i;
                sum+=fibo[i];
            }
            else {
                fibo[i] = fibo[i - 1] + fibo[i - 2];
                sum += fibo[i];
            }
        }
        return sum;
    }
}