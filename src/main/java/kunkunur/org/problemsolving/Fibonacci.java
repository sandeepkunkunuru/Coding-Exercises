package kunkunur.org.problemsolving;

public class Fibonacci {

	public static void main(String[] s) {

		for(int i=0 ; i < 20; i++){
			System.out.println(computeNthFibonacci(i, 0));
		}
		
		System.out.println("***************");
		
		int curNumber = 0;
		int lastOne = 0, lastButOne = 0;
		//Non-Recursive solution
		for(int i =0; i < 20; i++){
			if (i == 0) {
				curNumber = 1;
				lastButOne = curNumber;
			} else if (i == 1) {
				curNumber = 1;
				lastOne = curNumber;
			} else {
				int temp = lastButOne;
				lastButOne = curNumber;
				
				curNumber = lastOne + temp ;
				lastOne = curNumber;
			}	
			System.out.println(curNumber);
		}
		
	}

	// F(0) == 0; F(1) == 1;
	public static int computeNthFibonacci(int n, int result) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 1;
		} else {
			return computeNthFibonacci(n - 2, result) + computeNthFibonacci(n - 1, result);
		}
	}

}