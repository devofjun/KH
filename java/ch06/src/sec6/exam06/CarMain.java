package sec6.exam06;

public class CarMain {
	public static void main(String[] args) {
		Car car1 = new Car();
		System.out.println(car1.getSpeed());
		car1.setSpeed(100);
		System.out.println(car1.getSpeed());
		
		car1.setStop(false);
		System.out.println(car1.isStop());
		car1.setStop(true);
		System.out.println(car1.isStop());
		
		Person p1 = new Person("김종현", 25, 75.5f);
		System.out.println(p1); // 원래는 주소값이지만 자동으로 toString()을 실행
	}
}
