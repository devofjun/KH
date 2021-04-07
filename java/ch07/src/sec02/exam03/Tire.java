package sec02.exam03;

public class Tire {
	public int maxRotation;
	public int accumulatedRotation;
	public String location;
	
	public Tire() {
		
	}
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
}
