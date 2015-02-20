package EightPuzzle;

import Main.Operator;
import Main.State;
import Main.Utils;

public class EightPuzzleState extends State {
	private int currentX = 2;
	private int currentY = 2;
	private int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
	
	public EightPuzzleState() { super(); }
	
	public EightPuzzleState(EightPuzzleState state) {
		super();
		this.board = Utils.copyMatrix(state.board);
		this.currentX = state.currentX;
		this.currentY = state.currentY;
	}
	
	public EightPuzzleState(int[][] board, int currentX, int currentY)
	{
		super();
		this.board = board;
		this.currentX = currentX;
		this.currentY = currentY;
	}
	
	public boolean update(int dx, int dy) {
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
	
	@Override
	public State apply(Operator operator) {
		if (!(operator instanceof EightPuzzleOperator)) return null;
		
		Object[] args = operator.Arguments;
		EightPuzzleState state = new EightPuzzleState(this);
		
		return state.update((Integer)args[0], (Integer)args[1])? state: null;
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

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof EightPuzzleState))
			return false;
		
		EightPuzzleState state = (EightPuzzleState)obj;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (this.board[i][j] != state.board[i][j])
					return false;
		
		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		EightPuzzleState newState = new EightPuzzleState(this);
		return newState;
	}

	@Override
	protected boolean isFinal() {
		return this.equals(new EightPuzzleState(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}}, 2, 2));
	}

	@Override
	protected int hamming() {
		int count = 0;
		
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) 
				if (board[i][j] != ((i * 3) + j + 1)) 
					count++;
		
		if (board[2][2] == 0) 
			count--;
		
		return count;
	}
}
