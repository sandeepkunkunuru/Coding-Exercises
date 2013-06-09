/**
 * 
 * write a recursive program that tells me the number of combinations of change using american coins....
 * so for example 
 * 
 * change combination 1 for input $1.23 is →
 * 1 dollar coin, 2 dime coins, 3 pennies
 * 
 * change combination n is 
 * 123 pennies
 * 
 * what is n?
 */
package kunkunur.org.problemsolving;

import java.util.Arrays;
import java.util.HashSet;

public class ChangeCombinations {
	private static final int[] DENOMINATIONS = new int[] { 1, 5, 10, 25, 50, 100 };

	public static void main(String[] s) {
		// $1.23... possible combinations in which we can get this amount

		HashSet<String> combinations = new HashSet<String>();
		constructCombinations(123, 0, new int[] { 0, 0, 0, 0, 0, 0 }, combinations);

		System.out.println(combinations.size());
	}

	public static void constructCombinations(int a, int indexOfLastDenomination, int[] combination, HashSet<String> combinations) {
		
		if (a == 0) {
			String combinationString = Arrays.toString(combination);

			System.out.println(combinationString);

			combinations.add(combinationString);
		} else {
			// make a choice
			for (int i = indexOfLastDenomination; i < DENOMINATIONS.length; i++) {
				// System.out.println("Making" + DENOMINATIONS[i] + " choice");

				if (a >= DENOMINATIONS[i]) {
					int[] newCombination = combination.clone();

					newCombination[i] = combination[i] + 1;

					constructCombinations((a - DENOMINATIONS[i]), i, newCombination, combinations);
				}
			}
		}
	}

}
