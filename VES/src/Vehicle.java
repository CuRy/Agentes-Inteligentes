
public class Vehicle {
	int no_wheels;
	int no_doors;
	boolean motor;
	public enum Size {LARGE, MEDIUM, SMALL};
	Size size;
	public enum Type {AUTOMOBILE, CYCLE};
	Type type;
	public enum Mobile {BICYCLE, TRICYCLE, MOTORCYCLE, SPORTSCAR, SEDAN, MINIVAN, SPORTS_UTILITY_VEICLE, UNKNOWN};
	Mobile mobile;
	
	public Vehicle (int nw, int nd, int motor, int size) {
		if (nw >= 0)
			this.no_wheels = nw;
		if (nd >= 0)
			this.no_doors = nd;
		if (motor >= 0)
			this.motor = motor > 0;
		if (size >= 0)
			this.size = Size.values()[size];
		
		if (no_wheels < 4)
			type = Type.CYCLE;
		else
			type = Type.AUTOMOBILE;		
	}
	
	private boolean isBicycle() {
		return no_wheels == 2 && !motor;
	}
	
	private boolean isTricycle() {
		return no_wheels == 3 && !motor;
	}
	
	private boolean isMotorcycle() {
		return no_wheels == 2 && motor;
	}
	
	private boolean isSportsCar() {
		return size == Size.SMALL && no_doors == 2;
	}
	
	private boolean isSedan() {
		return size == Size.MEDIUM && no_doors == 4;
	}
	
	private boolean isMiniVan() {
		return size == Size.MEDIUM && no_doors == 3;
	}
	
	private boolean isSUV() {
		return size == Size.LARGE && no_doors == 4;
	}
	
	public Mobile classifyMe() {
		if (isBicycle())		 return Mobile.BICYCLE;
		if (isTricycle())		 return Mobile.TRICYCLE;
		if (isMotorcycle())		 return Mobile.MOTORCYCLE;
		if (isSportsCar()) 		 return Mobile.SPORTSCAR;
		if (isSedan()) 			 return Mobile.SEDAN;
		if (isMiniVan()) 		 return Mobile.MINIVAN;
		if (isSUV()) 			 return Mobile.SPORTS_UTILITY_VEICLE;
		
		return Mobile.UNKNOWN;
	}
	
}
