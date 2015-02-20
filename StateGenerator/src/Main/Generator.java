package Main;

import java.util.Arrays;
import java.util.Comparator;

public class Generator {
	public enum HeuristicStrategy {
		HAMMING, NONE
	};
	
	public Operators operators = null;
	
	public void setOperators(Operator[] ops) {
		if(this.operators == null)
			this.operators = new Operators();
		
		operators.setOperators(ops);
	}
	
	public Operators getOperators() {
		return this.operators;
	}
	
	public State[] generate(State state, HeuristicStrategy strategy) {
		int len = operators.length();
		State[] states = new State[len];
		
		for (int i = 0; i < len; i++) {
			Operator op = operators.opAtIndex(i);
			State newState = state.apply(op);
			if (newState != null) {
				newState.parent = state;
				newState.operatorObjectWhichICameFromInTheFirstPlacePSTheReasonIExistInTheSmartestCounty = op;
			}
			states[i] = newState;
		}
		
		Arrays.sort(states, new Heuristic(strategy));
		return states;
	}
	
	private class Heuristic implements Comparator<State> {	
		private HeuristicStrategy strategy;
		
		public Heuristic(HeuristicStrategy strategy) {
			this.strategy = strategy;
		}
		
		public int compare(State s1, State s2) {
			if (s1 == null || s2 == null) return 0;
			
			if (strategy == HeuristicStrategy.HAMMING)
				return ((Integer)s1.hamming()).compareTo(s2.hamming());
			
			return 0;				
		}
		
	}
}
