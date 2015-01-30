package Main;

public class Generator {
	public Operators operators = null;
	
	public void setOperators(char[] ops) {
		if(this.operators == null)
			this.operators = new Operators();
		
		operators.setOperators(ops);
	}
	
	public Operators getOperators() {
		return this.operators;
	}
	
	public State[] generate(State state) {
		int len = operators.length();
		State[] states = new State[len];
		
		for (int i = 0; i < len; i++) {
			char op = operators.opAtIndex(i);
			State newState = state.apply(op);
			if(newState != null) {
				newState.parent = state;
				newState.operatorFromWhichICameFromInTheFirstPlacePSTheReasonIExist = op;
			}
			states[i] = newState;
		}
		
		return states;
	}
}
