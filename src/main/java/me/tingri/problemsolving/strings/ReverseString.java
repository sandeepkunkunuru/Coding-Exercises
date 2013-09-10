package me.tingri.problemsolving.strings;

public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Example 1: Normal String
		String a = "this string needs to be reversed";
		char[] letters = a.toCharArray();
		StringBuilder stb = new StringBuilder();

		for (int i = 0; i < letters.length; i++) {
			stb.append(letters[letters.length - i - 1]);
		}

		System.out.println(a);
		System.out.println(stb.toString());

		//Example 2: String ending with a null character
		String cStyleString = "this string needs to be reversed\0";
		letters = cStyleString.toCharArray();
		stb = new StringBuilder();

		for (int i = 1; i < letters.length; i++) {
			stb.append(letters[letters.length - i - 1]);
		}

		System.out.println(cStyleString);
		System.out.println(stb.append('\0').toString());
		
		//Example 2, Algorithm 2: In place reversing
		stb = new StringBuilder(cStyleString);
		
		for (int i = 0; i < stb.length() /2; i++) {
			char temp = stb.charAt(stb.length() - i -2);
			stb.setCharAt(stb.length() - i -2, stb.charAt(i));
			stb.setCharAt(i, temp);
		}

		System.out.println(cStyleString);
		System.out.println(stb.append('\0').toString());
		
		
		
	}

}
