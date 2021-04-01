package sec03.exam03;
//p.240
public class CarExample {
	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car("k5");
		Car car3 = new Car("k5","Black");
		Car car4 = new Car("k5","white",200);
		System.out.println(car1.company+" "+car1.model+"-"+car1.color+"-"+car1.maxSpeed);
		System.out.println(car2.company+" "+car2.model+"-"+car2.color+"-"+car2.maxSpeed);
		System.out.println(car3.company+" "+car3.model+"-"+car3.color+"-"+car3.maxSpeed);
		System.out.println(car4.company+" "+car4.model+"-"+car4.color+"-"+car4.maxSpeed);
		
	}
}
