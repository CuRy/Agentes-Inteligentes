package Main;

public class Generator {
	public Operators operators = new Operators();
	
	public void setOperators(char[] ops) {
		operators.setOperators(ops);
	}
	
	public State[] generate(State state) {
		int len = operators.length();
		State[] states = new State[len];
		
		for (int i = 0; i < len; i++) {
			char op = operators.opAtIndex(i);
			State newState = state.apply(op);
			newState.parent = state;
			newState.operatorFromWhichICameFromInTheFirstPlacePSTheReasonIExist = op;
			states[i] = newState;
		}
		
		return states;
	}
}
