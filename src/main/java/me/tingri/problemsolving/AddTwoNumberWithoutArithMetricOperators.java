package me.tingri.problemsolving;

public class AddTwoNumberWithoutArithMetricOperators {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 10;
		int b = 20;

		// end state is a + b = 30;

		for (; a < 100 && b < 200; a = a + 10, b = b + 20) {
			int initiala = a;
			int initialb = b;
			//common 1's
			int temp = (a & b);
			
			while (temp > 0) {
				//unique 1's
				int temp2 = (a & b) ^ (a | b);
				
				//adding common 1s twice
				int temp3 = temp << 1;
				
				a = temp3;
				b = temp2;
				
				temp = a & b;
			} 
			
			System.out.println("There  a=" + initiala + " b=" + initialb + " "  + (a | b));
			
			a = initiala;
			b = initialb;
		}
	}

}
