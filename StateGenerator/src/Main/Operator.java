package Main;


public abstract class Operator {
	public Object[] Arguments;
	public String name;
	public abstract Object[] generateArgs();
	public String toString() {
		return name;
	}
}
