package sec03.exam04;

public class Car {
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	Car() {
		System.out.println("#Car() 실행됨");
	}
	Car(String model){
		this(model, "은색", 250);
		System.out.println("#Car(String) 실행됨");
	}
	Car(String model, String color){
		System.out.println("#Car(String, String) 실행됨");
	}
	Car(String model, String color, int maxSpeed){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
		System.out.println("#Car(String, String, int) 실행됨");
	}
}
