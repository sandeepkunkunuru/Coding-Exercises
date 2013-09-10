package me.tingri.problemsolving;

import java.util.ArrayList;

public class Fibonacci {

	public static void main(String[] s) {
		ArrayList<Integer> a = new ArrayList<Integer>(), b = new ArrayList<Integer>();
		
		// Recursive solution
		for (int i = 0; i < 20; i++) {
			a.add(computeNthFibonacci(i, 0));
		}

		// Non-Recursive solution
		System.out.println("***************");

		int curNumber = 1;
		int lastOne = 1, lastButOne = 1;
		
		b.add(1);
		b.add(1);
		
		for (int i = 2; i < 20; i++) {
			int temp = lastButOne;
			lastButOne = curNumber;

			curNumber = lastOne + temp;
			lastOne = curNumber;
			b.add(curNumber);
		}
		
		for(int i= 0; i < 20; i++){
			System.out.println(a.get(i) + "  " + b.get(i)+ " " + (a.get(i).intValue() == b.get(i).intValue()));
		}
	}

	// F(0) == 0; F(1) == 1; F(2) = F1(0) + F(1); F(3) = F(2) + F(1); and so on.
	public static int computeNthFibonacci(int n, int result) {
		if (n == 0|| n == 1) {
			return 1;
		} else {
			return computeNthFibonacci(n - 2, result)
					+ computeNthFibonacci(n - 1, result);
		}
	}

}