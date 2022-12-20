package com.epam.rd.autotasks.array;

import java.util.Arrays;

public class IntArrayUtil {

	public static void swapEven(int[] array) {
		if (array==null || array.length==0){

		}
		else {
			for (int i = 0; i < array.length/2; i++) {
				if (array[i]%2==0 && array[array.length-i-1]%2==0){
					int tmp=array[i];
					array[i]=array[array.length-1-i];
					array[array.length-1-i]=tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		{
			int[] array = null;
			swapEven(array);
			System.out.println(Arrays.toString(array));
		}
		{
			int[] array = new int[] {};
			swapEven(array);
			System.out.println(Arrays.toString(array));
		}
		{
			int[] array = new int[] { 10, 5, 3, 4 };
			swapEven(array);
			System.out.println(Arrays.toString(array));
		}
		{
			int[] array = new int[] { 100, 2, 3, 4, 5 };
			swapEven(array);
			System.out.println(Arrays.toString(array));
		}
		{
			int[] array = new int[] { 100, 2, 3, 45, 33, 8, 4, 54 };
			swapEven(array);
			System.out.println(Arrays.toString(array));
		}
	}

}
