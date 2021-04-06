package car3;

public class CarMain {
	public static void main(String[] args) {
		Car c1 = new Car();
		c1.name = "카1";
		c1.drive();
		
		Truck t1 = new Truck();
		t1.name = "트1";
		t1.drive();
		
		Car c2 = new Truck(); // upcasting(업캐스팅)
		//Truck t2 = new Car(); // 오류남.
		
	}
}
