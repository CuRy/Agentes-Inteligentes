package EightPuzzle;

import Main.Operator;

public class EightPuzzleOperator extends Operator {
	public EightPuzzleOperator(int dx, int dy) {
		this.Arguments = new Object[2];
		Arguments[0] = dx;
		Arguments[1] = dy;
	}
	
	@Override
	public Object[] generateArgs()
	{
		return null;
	}
}
