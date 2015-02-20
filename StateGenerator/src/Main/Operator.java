package Main;

import java.util.Arrays;

public abstract class Operator {
	public Object[] Arguments;
	public abstract Object[] generateArgs();
	public String toString() {
		return Arrays.toString(Arguments);
	}
}
