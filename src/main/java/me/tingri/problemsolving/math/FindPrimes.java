package me.tingri.problemsolving.math;

import java.util.Arrays;

public class FindPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int boundary = 23;

		findPrimes(boundary);
	}

	private static void findPrimes(int boundary) {
		//int primes[] = new int[(int) Math.floor(Math.sqrt(boundary))];
		
		int primes[] = new int[boundary / 2];
		primes[0] = 2;

		int currentSize = 1;

		for (int i = 3; i < boundary; i++) {
			boolean newprime = true;
			
			for (int j = 0; j < currentSize; j++) {
//				System.out.println(primes[j]);
				if ((i % primes[j]) == 0) {
					newprime = false;
					break;
				}
			}
			
			if (newprime) {
				primes[currentSize] = i;
				currentSize++;
			}			
		}
		
		System.out.println(Arrays.toString(primes));
	}

}
