package com.epam.rd.autotasks;


class LoopStatements {
    public static int sumOfBinary(int n) {
       String [] result=Integer.toString(n,2).split("");
       int sum=0;
       for (String s:result){
           if (Integer.parseInt(s)==1){
               sum+=Integer.parseInt(s);
           }
       }
       return sum;
    }
}
