package pkg;

import java.util.concurrent.TimeUnit;

public class FireModel {
	public static int SIZE = 47;
	private FireCell[][] myGrid;
	private FireView myView;

	public FireModel(FireView view) {
		myGrid = new FireCell[SIZE][SIZE];
		int setNum = 0;
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				myGrid[r][c] = new FireCell();
			}
		}

		myView = view;
		myView.updateView(myGrid);

	}

	/*
	 * recursiveFire method here
	 */
	public void recursiveFire(int x, int y) {
		if (x < 0 || y < 0 || x >= SIZE || y >= SIZE || myGrid[y][x].getStatus() != 1)
			return;
		
		myView.updateView(myGrid);
		try {
			TimeUnit.MILLISECONDS.sleep(2);
		} catch (Exception e) {
			
		}

		myGrid[y][x].setStatus(2);

		recursiveFire(x, y - 1);
		recursiveFire(x, y + 1);
		recursiveFire(x + 1, y);
		recursiveFire(x - 1, y);		
		
	}

	public void solve() {
		// student code here

		for (int i = 0; i < SIZE; i++) {
			if (myGrid[SIZE - 1][i].getStatus() == 1) {
				recursiveFire(i, SIZE - 1);
				
			}
		}
		boolean inTrouble = false;
		for (int i = 0; i < SIZE; i++) {
			if (myGrid[0][i].getStatus() == 2) {
				inTrouble = true;
			}
		}

		if (inTrouble) {
			System.out.println("Onett is in trouble!");
		} else {
			System.out.println("Onett is safe.");
		}

		myView.updateView(myGrid);

	}

}
