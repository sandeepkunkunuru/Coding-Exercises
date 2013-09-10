package me.tingri.problemsolving.bitops;
/**
 * 
 * 
You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a
method to set all bits between i and j in N equal to M (e.g., M becomes a substring of
N located at i and starting at j).
EXAMPLE:
Input: N = 10000000000, M = 10101, i = 2, j = 6
Output: N = 10001010100
 * @author kunkunur
 *
 */
public class MakeOneNumberSubStringOfAnother {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 0X00000400, b = 0X00000015;
		int i = 2, j = 7;
		
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		
/*		System.out.println(Integer.toBinaryString( ~0 ));
		System.out.println(Integer.toBinaryString( ~0 >> 6));
		
		System.out.println(Integer.toBinaryString(1 ));
		System.out.println(Integer.toBinaryString( 1 << 6));
		System.out.println(Integer.toBinaryString( -1 << 3));
*/
		
		// First empty j--i of a 
		int max = ~0;
		
		int left  = max - ((1 << j) - 1);
		
		System.out.println(Integer.toBinaryString(left));

		
		int right = (1 << i) -1;
		
		System.out.println(Integer.toBinaryString(right));

		
		int temp1 = left + right;
		
		System.out.println(Integer.toBinaryString(temp1));
		
		a = a & temp1;
		
		System.out.println(Integer.toBinaryString(a));
		
		int temp = b << i;

		System.out.println(Integer.toBinaryString(temp));
		
		a = a | temp;
		
		System.out.println(Integer.toBinaryString(a));
	}

}
