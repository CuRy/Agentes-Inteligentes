package EightPuzzle;

import Main.Operator;

public class EightPuzzleOperator extends Operator {
	public Object[] args = {0, 0};
	
	public EightPuzzleOperator(int dx, int dy) {
		args[0] = dx;
		args [1] = dy;
	}
}
