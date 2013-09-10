/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 */
package me.tingri.problemsolving;

/**
 * @author kunkunur
 *
 */
public class FindDuplicateChars {
	private static final String input1 = "Sandeep1";
	private static final String input2 = "uniqe";
	private static final String input3 = " not so unique";

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//With Additinal data structures
		System.out.println("Input '" + input1 + "' has unique letters :" + !containsDuplicateChars(input1));
		System.out.println("Input '" + input2 + "' has unique letters :" + !containsDuplicateChars(input2));
		System.out.println("Input '" + input3 + "' has unique letters :" + !containsDuplicateChars(input3));
		
		//Without Additional data structures
		System.out.println("Input '" + input1 + "' has unique letters :" + !containsDuplicateChars2(input1));
		System.out.println("Input '" + input2 + "' has unique letters :" + !containsDuplicateChars2(input2));
		System.out.println("Input '" + input3 + "' has unique letters :" + !containsDuplicateChars2(input3));
		
	}


	/**
	 * Creates additional data structures
	 * 
	 * @param input
	 * @return
	 */
	private static boolean containsDuplicateChars(String input) {
		boolean[] letterCount = new boolean[256];
		
		for (char letter : input.toCharArray()) {
			if(letterCount[letter % 256] == false) {
				letterCount[letter % 256] = true;
			} else { 
				return true;
			}
		}
		
		return false;
	}
	

	/**
	 * Does not create additional data structures 
	 * @param input
	 * @return
	 */
	private static boolean containsDuplicateChars2(String input) {
		int size = input.length();
		
		for (int i = 0; i < size; i++) {
			char letter1 = input.charAt(i);
			
			for (int j = i + 1; j < size; j++) {
				if (letter1 == input.charAt(j)){
					return true;
				}
			}
		}
		
		return false;
	}
}
