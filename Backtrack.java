package pkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtrack {
	static void printBinary(int digits) {
		if (digits <= 0)
			return;

		printBinaryHelper(digits, "0");
		printBinaryHelper(digits, "1");

	}

	private static void printBinaryHelper(int digits, String soFar) {
		if (soFar.length() == digits) {
			System.out.print(soFar + " ");
			return;
		}
		printBinaryHelper(digits, soFar + "0");
		printBinaryHelper(digits, soFar + "1");

	}

	static void climbStairs(int steps) {
		if (steps <= 0)
			return;

		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		climbStairsHelper(steps, list);
		list.clear();
		list.add(2);
		climbStairsHelper(steps, list);
	}

	private static void climbStairsHelper(int steps, ArrayList<Integer> list) {
		int num = 0;
		for (int n : list) {
			num += n;
		}
		
		if (num == steps) {
			System.out.println(list);
			return;
		}
		if (num > steps) {
			return;
		}

		ArrayList<Integer> list2 = (ArrayList<Integer>) list.clone();
		list.add(1);
		climbStairsHelper(steps, list);
		list2.add(2);
		climbStairsHelper(steps, list2);

	}

	static void campsite(int x, int y) {
		campsiteHelper(x, y, 0, 0, "");
	}

	private static void campsiteHelper(int x, int y, int xc, int yc, String directions) {
		if (x == xc && y == yc) {
			System.out.println(directions);
			return;
		} else if (xc > x || yc > y) {
			return;
		}

		campsiteHelper(x - 1, y, xc, yc, directions + "E ");
		campsiteHelper(x, y - 1, xc, yc, directions + "N ");
		campsiteHelper(x - 1, y - 1, xc, yc, directions + "NE ");

	}

	static int getMax(List<Integer> nums, int limit) {
		return limit - getMaxHelper(0, nums, limit, limit);
	}

	private static int getMaxHelper(int start, List<Integer> nums, int limit, int currentBest) {
		if (start >= nums.size() && limit > 0) {
			if (limit < currentBest && limit > 0)
				return limit;
			return currentBest;
		} else if (start >= nums.size())
			return currentBest;

		int current = getMaxHelper(start + 1, nums, limit - nums.get(start), currentBest);
		if (current < currentBest)
			currentBest = current;
		current = currentBest = getMaxHelper(start + 1, nums, limit, currentBest);
		if (current < currentBest)
			currentBest = current;

		return currentBest;
	}


	public static void main(String args[]) {
		printBinary(0);
		System.out.println();
		printBinary(1);
		System.out.println();
		printBinary(2);
		System.out.println();
		printBinary(3);
		System.out.println();
		System.out.println();

		climbStairs(4);
		System.out.println();

		campsite(2, 1);
		System.out.println();

		System.out.println(getMax(Arrays.asList(7, 30, 8, 22, 6, 1, 14), 19));
		
		//makeChange(25);
		//makeChange(100);
	}

}