package EightPuzzle;

import Main.State;

public class EightPuzzleState extends State {
	private int currentX = 2;
	private int currentY = 2;
	private int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
	
	public EightPuzzleState() {}
	
	public EightPuzzleState(EightPuzzleState state) {
		this.board = state.copyBoard();
		this.currentX = state.currentX;
		this.currentY = state.currentY;
	}
	
	private boolean update(int dx, int dy) {
		if (isValid(dx, dy)) {
			board[currentY][currentX] = board[currentY + dy][currentX + dx];
			board[currentY + dy][currentX + dx] = 0;
			currentX += dx;
			currentY += dy;
			return true;
		}
		
		return false;
	}
		
	private boolean isValid(int dx, int dy) {
		int x = currentX + dx;
		int y = currentY + dy;

		return x > -1 && x < 3 && y > -1 && y < 3;	
	}
	
	private int[][] copyBoard() {
		int[][] copy = new int[3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) 
				copy[i][j] = board[i][j];
		
		return copy;
	}
	
	@Override
	public State apply(char op) {
		EightPuzzleState state = new EightPuzzleState(this);
		int dx = 0, dy = 0;
		
		switch (op) {
			case 'L': 
				dx++;
				break;
			case 'R': 
				dx--;
				break;
			case 'U':
				dy++;
				break;
			case 'D': 
				dy--;
				break;
		}
		return state.update(dx, dy)? state: null;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				s += board[i][j] + " ";			
			s += "\n";
		}
		return s;
	}
}
