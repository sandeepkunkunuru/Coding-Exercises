package me.tingri.problemsolving;

public class SwapInPlace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		bitWiseSwap(a, b);
		arithmeticSwap(a, b);

	}

	private static void arithmeticSwap(int a, int b) {
		//end state is a = 20 and b = 10;
		a = a - b;
		
		b = b + a;
		
		a = b - a;
		
		System.out.println(a);
		System.out.println(b);
	}

	private static void bitWiseSwap(int a, int b) {
		//end state is a = 20 and b = 10;
		
		a = a ^ b;
		
		b = a ^ b;
		
		a = a ^ b;

		System.out.println(a);
		System.out.println(b);
	}

}
