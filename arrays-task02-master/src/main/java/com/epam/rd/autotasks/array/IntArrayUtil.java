package com.epam.rd.autotasks.array;



public class IntArrayUtil {

	public static int maximumDistance(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int max = 0;
		int indexFirstMax = 0;
		int indexLastMax = 0;
		int result;
		for (int i = 0;i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
				indexFirstMax = i;
			}
		}
		for (int i = array.length-1; i >= 0; i--) {
			if (array[i]==max){
				indexLastMax = i;
				break;
			} else if (i==0) {
				return 0;
			}
		}
		return result=indexLastMax-indexFirstMax;
	}

	public static void main(String[] args) {
		{
			int[] array = null;
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] {};
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] { 4, 100, 3, 4 };
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] { 5, 50, 50, 4, 5 };
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] { 5, 350, 350, 4, 350 };
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] { 10, 10, 10, 10, 10 };
			System.out.println("result = " + maximumDistance(array));
		}
	}

}
