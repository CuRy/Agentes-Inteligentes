package EightPuzzle;

import Main.Generator;
import Main.State;

public class EightPuzzleSolver {
	private Generator generator = new Generator();
	
	public EightPuzzleSolver() {
		char[] operators = { 'L', 'R', 'U', 'D' };
		generator.setOperators(operators);
	}
	
	public void solve() {
		for (State s: generator.generate(new EightPuzzleState()))
			if (s != null)
				System.out.println((EightPuzzleState) s);
		
	}
	public static void main(String[] args) {
		EightPuzzleSolver solver = new EightPuzzleSolver();
		solver.solve();
	}
}
