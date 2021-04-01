package sec04.exam03;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();
		car.setGas(5);
		if(car.isLeftGas()) {
			System.out.println("춮발합니다.");
			car.run();
		} else {
		}
	}
}
