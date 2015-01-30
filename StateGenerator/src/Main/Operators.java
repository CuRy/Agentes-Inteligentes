package Main;

public class Operators {
	private char[] operators;
	
	public void setOperators(char[] operators) {
		this.operators = operators;
	}
	
	public char[] getOperators() {
		return operators;
	}
	
	public int length() {
		return operators.length;
	}
	
	public char opAtIndex(int index) {
		return operators[index];
	}
}
