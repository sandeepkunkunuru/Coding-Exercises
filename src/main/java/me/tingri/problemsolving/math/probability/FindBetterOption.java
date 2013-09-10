package me.tingri.problemsolving.math.probability;

/**
 * 
You have a basketball hoop and someone says that you can play 1 of 2 games.
Game #1: You get one shot to make the hoop.
Game #2: You get three shots and you have to make 2 of 3 shots.
If p is the probability of making a particular shot, for which values of p should you pick
one game or the other?
 * @author kunkunur
 *
 */
public class FindBetterOption {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double p ;
		int trialSize = 100;
		
		for (int i = 0; i < trialSize; i++){
			p = (1.0/trialSize) * i;
					
			System.out.println("P=" + p + " choice="+ choice(p));
		}
		
		System.out.println("Always game 1");
	}

	private static int choice(double p) {
		return (Math.pow(p, 2)*3*(1-p) + Math.pow(p, 3) - p) > 0 ? 2: 1;
	}

}
