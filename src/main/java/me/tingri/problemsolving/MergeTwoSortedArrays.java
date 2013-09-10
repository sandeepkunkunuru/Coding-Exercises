package me.tingri.problemsolving;

import java.util.Arrays;

/**
 * You are given two sorted arrays, A and B, and A has a large enough buffer at
 * the end to hold B. Write a method to merge B into A in sorted order.
 */

public class MergeTwoSortedArrays {

	public static void main(String[] s) {
		int[] array1 = { 1, 2, 4, 6, 7, 0, 0, 0 };
		int[] array2 = { 3, 5, 12 };

		int size1 = 5;
		int size2 = 3;

		mergeArrays(array1, array2, size1, size2);

		int[] array3 = { 1, 2, 4, 6, 7, 0, 0, 0, 0, 0 };
		int[] array4 = { 2, 3, 5, 12, 23 };

		int size3 = 5;
		int size4 = 5;

		mergeArrays(array3, array4, size3, size4);

		int[] array5 = { 1, 2, 0, 0, 0, };
		int[] array6 = { 3, 5, 12 };

		int size5 = 2;
		int size6 = 3;

		mergeArrays(array5, array6, size5, size6);
	}

	private static void mergeArrays(int[] array1, int[] array2, int size1,
			int size2) {
		int i = 0, j = 0;

		for (; i < size1 + size2 && j < size2;) {
			if (array2[j] >= array1[i]) {
				i++;
				continue;
			}

			int l = i, k = j;

			for (; k < size2; k++) {
				if (array2[k] < array1[l]) {
					break;
				}
			}

			// Move array1 elements by k -j+ 1 spots from j th position
			int size = k - j + 1;
			for (int m = size1 + size2 -1; m > i; m--) {
				array1[m] = array1[m - size];
				
			}
			 //System.out.println(Arrays.toString(array1) + size);
			// copy array2 elements to array1
			int n = i, o = j;
			for (; n < i + size && o < j + size; n++, o++) {
				array1[n] = array2[o];
			}

			i = n;
			j = o;
		}
		
		 /*System.out.println(i); 
		 System.out.println(j);
		 
		 System.out.println(Arrays.toString(array1));*/
		 
		// copy remaining array2 elements to array1
		for (int o = j; o < size2; o++) {
			array1[size1 + o] = array2[o];
		}

		System.out.println(Arrays.toString(array1));
	}
}