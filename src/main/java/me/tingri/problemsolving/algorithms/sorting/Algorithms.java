package me.tingri.problemsolving.algorithms.sorting;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;

public class Algorithms<T extends Comparable<T>> {

	public Algorithms() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Algorithms<Integer> algorithm = new Algorithms<Integer>();
		
		Integer[] values = new Integer[] { 4, 5, 1, 2, 4, 6, 3 };

		//values = algorithm.mergeSort(values);
		
		System.out.println(ArrayUtils.toString(values));

	}

}
