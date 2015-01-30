package Main;

public class Generator {
	public Operators operators = new Operators();
	
	public void setOperators(char[] ops) {
		operators.setOperators(ops);
	}
	
	public State[] generate(State state) {
		int len = operators.length();
		State[] states = new State[len];
		System.out.println(state);
		for (int i = 0; i < len; i++)
			states[i] = state.apply(operators.opAtIndex(i));
		
		return states;
	}
}
