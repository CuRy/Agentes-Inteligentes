package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Solver {
	
	public enum SolveStrategy {
		DFS, BFS
	}
	
	public Solver()
	{
		this.verbose = 0;
	}
	
	public Solver(int verbose)
	{
		this.verbose = verbose;
	}
	
	private Generator generator = new Generator();
	
	/**Verbose level*/
	private int verbose = 0;
	
	/**search start time in nanoeconds. verbose level 1*/
	private long startTime;
	
	/**search end time in nanoseconds. verbose level 1*/
	private long endTime;
	
	/**total states generated before finding solution. verbose level 2*/
	private long generatedStates;
	
	/**print solution when found. verbose level 3*/
	private boolean printSolution;
	
	
	public void setOperators(char[] operators) {
		
		this.generator.setOperators(operators);
	}
	
	public ArrayList<State> visited = new ArrayList<State>();
	
	public State DFS(State initial, State goal) {
		Stack<State> stack = new Stack<State>();
		State[] next;
		State currentState = initial;
		if(verbose >= 1) // verbose
			System.out.println("DFS Solving started...");
		
		this.startTime = System.nanoTime();
		while (!currentState.equals(goal)) {
			next = generator.generate(currentState);
			for (int i = 0; i < next.length; i++) {
				if (next[i] != null && !visited.contains(next[i])) {
					generatedStates++;
					stack.push(next[i]);
					visited.add(next[i]);
				}
			}
			
			if (!stack.isEmpty())
				currentState = stack.pop();	
			else {
				this.endTime = System.nanoTime();
				return null;
			}
		}
		
		this.endTime = System.nanoTime();
		return currentState;
	}	
	
	private State BFS(State initial, State goal) throws CloneNotSupportedException {
		
		LinkedList<State> queue = new LinkedList<State>();
		State[] next;
		State currentState = (State) initial.clone();
		if(verbose > 0)// verbose
			System.out.println("BFS Solving started...");
		
		this.startTime = System.nanoTime();
		while (!currentState.equals(goal)) {
			next = generator.generate(currentState);
			for (int i = 0; i < next.length; i++) {
				if (next[i] != null && !visited.contains(next[i])) {
					generatedStates++;
					queue.add(next[i]);
					visited.add(next[i]);
				}
			}

			if (!queue.isEmpty())
				currentState = queue.poll();	
			else {
				this.endTime = System.nanoTime();
				return null;
			}
		}
		
		this.endTime = System.nanoTime();
		return currentState;
	}
	
	public ArrayList<Character> Solve(State initial, State goal,
										SolveStrategy strategy) throws CloneNotSupportedException {
		if(this.generator.getOperators() == null)
			return null;
		
		if(initial == null || goal == null)
			return null;
		
		State state = null;
		// restore initial values for calculations
		this.visited.removeAll(this.visited);
		this.generatedStates = 0;
		ArrayList<Character> solution = null;
		
		switch (strategy) {
			case DFS:
				state = DFS(initial, goal);
				break;
			case BFS:
				state = BFS(initial, goal);
				break;
		}
		
		if (state != null)
			solution = backtrack(state);
			
		if(verbose >= 1)
		{
			if(verbose >= 2)
				System.out.println("generated " + this.generatedStates + " states.");
			
			if(solution != null)
			{
				System.out.println("Solution found in " + (this.endTime - startTime)/1000000 + " miliseconds.");
				if(verbose >= 2)
				{
					System.out.println("solution has " + solution.size() + " operations.");
				}
				if(verbose >= 3)
					System.out.println("solution: " + solution);
			}else
			{
				System.out.println("No solution found. Spent " + (this.endTime - startTime)/1000000 + " miliseconds.");
			}
		}
		
		return solution;
	}
	
	private ArrayList<Character> backtrack(State state) {
		ArrayList<Character> mySolution = new ArrayList<Character>();
		while(state.parent != null)
		{
			mySolution.add(state.operatorFromWhichICameFromInTheFirstPlacePSTheReasonIExist);
			state = state.parent;
		}
		Collections.reverse(mySolution);
		return mySolution;
	}
}
