package kunkunur.org.problemsolving.math;


public class SquareRoot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(sqrt(9));
		System.out.println(sqrt(21));

	}
	
	public static  int sqrt(int num) {
        int op = num;
        int res = 0;
        int one = 1 << 30; // The second-to-top bit is set: 1L<<30 for long
 
        // "one" starts at the highest power of four <= the argument.
        while (one > op)
            one >>= 2;
 
        while (one != 0) {
            if (op >= res + one) {
                op -= res + one;
                res += one << 1;
            }
            res >>= 1;
            one >>= 2;
        }
        return res;
    }

}
