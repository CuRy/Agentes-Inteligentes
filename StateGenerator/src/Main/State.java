package Main;

public abstract class State {
	public State parent;
	public char operatorFromWhichICameFromInTheFirstPlacePSTheReasonIExist;
	public abstract State apply(char op);
	
	public State()
	{
		this.parent = null;
		this.operatorFromWhichICameFromInTheFirstPlacePSTheReasonIExist = 0;
	}
	
	@Override
	public abstract boolean equals(Object obj);

	@Override
	protected abstract Object clone() throws CloneNotSupportedException;
	
	
	
}
