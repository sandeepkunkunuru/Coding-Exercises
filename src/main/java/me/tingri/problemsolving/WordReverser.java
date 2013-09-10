/**
 * Given a character array (char[] input) that contains "words" separated by spaces, create a function to reverse the words in the array. 
 * 
 * For example, given ['H', 'i', ' ', 'W', 'o', 'r', 'l', 'd'] produce ['W', 'o', 'r', 'l', 'd', ' ', 'H', 'i']. 
 * 
 * For the purposes of this problem the input will contain only letters and spaces. Be sure your solution tolerates leading, trailing, and multiple spaces.
 */
package me.tingri.problemsolving;

import java.util.Arrays;

public class WordReverser {
	private static final char[] input1 = new char[] { 'F', 'o', 'o', ' ', 'W', 'o', 'r', 'l', 'd' };
	private static final char[] input2 = new char[] { ' ','H', 'i',' ', ' ' , ' ', 'W', 'o', 'r', 'l', 'd' };
	private static final char[] input3 = new char[] { 'F', 'o', 'o', ' ', 'W', 'o', 'r', 'l', 'd', ' ', ' ' , ' ', 'i', 's', '.', ' ' , ' '};

	public static void main(String[] s) {
		System.out.println("Output is" + Arrays.toString(reverse(input1)));
		System.out.println("Output is" + Arrays.toString(reverse(input2)));
		System.out.println("Output is" + Arrays.toString(reverse(input3)));
	}

	private static char[] reverse(char[] input) {
		char[] output = new char[input.length];

		// try to find out start of a word and try to capture the complete word
		int start = -1, end = -1;
		int outputIndex = input.length - 1;

		for (int i = 0; i < input.length; i++) {
			if (input[i] != ' ') { 
				if (start == -1) {
					start = i;
				} else if (i == input.length - 1) {
					end = input.length - 1;

					outputIndex = appendWord(start, end, input, output, outputIndex);

					start = -1;
					end = -1;
				}
			} else if (start != -1 && end == -1) {
				end = i - 1;

				outputIndex = appendWord(start, end, input, output, outputIndex);

				output[outputIndex--] = ' ';
				start = -1;
				end = -1;
			} else if (start == -1 && end == -1) {
				output[outputIndex--] = input[i];
			}
		}

		return output;
	}

	private static int appendWord(int start, int end, char[] input, char[] output, int outputIndex) {
		int lengthOftheWord = end - start;

		for (int i = 0; i <= lengthOftheWord; i++) {
			output[outputIndex--] = input[end - i];
		}
		
		return outputIndex;
	}

}
