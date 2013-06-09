package kunkunur.org.problemsolving;

import org.apache.commons.lang.ArrayUtils;

public class SingleArrayMultipleStacks {
	private static final int SIZE = 12;
	private static final int NUM_STACKS = 3;
	// This is the array that we will try to use to build three stacks. Now
	// how??
	int[] array = new int[SIZE];
	int[] indexes = { (SIZE/NUM_STACKS)*(NUM_STACKS -3) -1,
					  (SIZE/NUM_STACKS)*(NUM_STACKS -2) -1,
					  (SIZE/NUM_STACKS)*(NUM_STACKS -1) -1};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleArrayMultipleStacks sams = new SingleArrayMultipleStacks();
		try {
			sams.push(1, 11);
			sams.push(2, 21);
			sams.push(3, 31);

			sams.push(1, 12);
			sams.push(2, 22);
			sams.push(3, 32);

			sams.push(1, 13);
			sams.push(2, 23);
			sams.push(3, 33);

			System.out.println(sams.pop(1));
			System.out.println(sams.pop(1));
			System.out.println(sams.pop(1));

			System.out.println(sams.pop(2));
			System.out.println(sams.pop(2));

			System.out.println(sams.pop(3));

			sams.push(2, 24);
			sams.push(3, 34);

			System.out.println(sams.pop(3));
			System.out.println(sams.pop(3));
			System.out.println(sams.pop(3));

			System.out.println(ArrayUtils.toString(sams.array));
			System.out.println(ArrayUtils.toString(sams.indexes));
			
			try {
				// I should get an exception at this point.
				System.out.println(sams.pop(3));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sams.push(2, 25);
			sams.push(2, 26);

			System.out.println(ArrayUtils.toString(sams.array));
			System.out.println(ArrayUtils.toString(sams.indexes));
			
			// I should get an exception at this point also.
			sams.push(2, 27);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void push(int stackNumber, int value) throws Exception {
		int temp = stackNumber - 1;

		if (indexes[temp] == (stackNumber * SIZE / NUM_STACKS - 1)) {
			throw new Exception("stack full");
		}

		indexes[temp] += 1;
		array[indexes[temp]] = value;
	}

	int pop(int stackNumber) throws Exception {
		int temp = stackNumber - 1;

		if (indexes[temp] == (temp * SIZE / NUM_STACKS - 1)) {
			throw new Exception("Nothing to pop");
		}

		int value = array[indexes[temp]];

		// reset the value
		array[indexes[temp]] = 0;

		indexes[temp] -= 1;

		return value;
	}

}
