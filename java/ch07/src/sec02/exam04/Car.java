package sec02.exam04;

public class Car {
	// 앞바퀴
	public Tire tire1;
	public Tire tire2;
	// 뒷바퀴
	public Tire tire3;
	public Tire tire4;
	
	public Car(Tire tire1, Tire tire2, Tire tire3, Tire tire4) {
		super();
		this.tire1 = tire1;
		this.tire2 = tire2;
		this.tire3 = tire3;
		this.tire4 = tire4;
	}
}
