package Main;

public class Operators {
	private Operator[] operators;
	
	public void setOperators(Operator[] operators) {
		this.operators = operators;
	}
	
	public Operator[] getOperators() {
		return operators;
	}
	
	public int length() {
		return operators.length;
	}
	
	public Operator opAtIndex(int index) {
		return operators[index];
	}
}
