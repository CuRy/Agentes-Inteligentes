package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Solver {
	
	public enum SolveStrategy {
		DFS, BFS
	}
	
	private Generator generator = new Generator();
	
	public void setOperators(char[] operators) {
		
		this.generator.setOperators(operators);
	}
	
	public ArrayList<State> visited = new ArrayList<State>();
	
	public State DFS(State initial, State goal) {
		Stack<State> stack = new Stack<State>();
		State[] next;
		State currentState = initial;
		
		while (!currentState.equals(goal)) {
			next = generator.generate(currentState);
			for (int i = 0; i < next.length; i++) {
				if (next[i] != null && !visited.contains(next[i])) {					
					stack.push(next[i]);
					visited.add(next[i]);
				}
			}
			
			if (!stack.isEmpty())
				currentState = stack.pop();	
			else
				return null;
		}
		
		return currentState;
	}	
	
	private State BFS(State initial, State goal) throws CloneNotSupportedException {
		
		LinkedList<State> queue = new LinkedList<State>();
		State[] next;
		State currentState = (State) initial.clone();
		
		while (!currentState.equals(goal)) {
			next = generator.generate(currentState);
			for (int i = 0; i < next.length; i++) {
				if (next[i] != null && !visited.contains(next[i])) {					
					queue.add(next[i]);
					visited.add(next[i]);
				}
			}

			if (!queue.isEmpty())
				currentState = queue.poll();	
			else
				return null;
		}
		
		return currentState;
	}
	
	public ArrayList<Character> Solve(State initial, State goal,
										SolveStrategy strategy) throws CloneNotSupportedException {
		if(this.generator.getOperators() == null)
			return null;
		
		if(initial == null || goal == null)
			return null;
		
		State state = null;
		this.visited.removeAll(this.visited);
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
