package sec03.exam04;
//p.240
public class CarExample {
	public static void main(String[] args) {
		Car car1 = new Car();
		System.out.printf("%s, %s/%s 최대시속:%d\n",car1.company,car1.model,car1.color,car1.maxSpeed);
		
		Car car2 = new Car("자가용");
		System.out.printf("%s, %s/%s 최대시속:%d\n",car2.company,car2.model,car2.color,car2.maxSpeed);
	}
}
