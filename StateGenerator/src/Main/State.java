package Main;

public abstract class State {
	public State parent;
	public Operator operatorObjectWhichICameFromInTheFirstPlacePSTheReasonIExistInTheSmartestCounty;
	public abstract State apply(Operator op);
	
	public State()
	{
		this.parent = null;
		this.operatorObjectWhichICameFromInTheFirstPlacePSTheReasonIExistInTheSmartestCounty = null;
	}
	
	@Override
	public abstract boolean equals(Object obj);

	@Override
	protected abstract Object clone() throws CloneNotSupportedException;
	
	protected abstract boolean isFinal();
	
	protected abstract int hamming();
}
