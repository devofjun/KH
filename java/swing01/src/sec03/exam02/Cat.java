package sec03.exam02;

public class Cat extends Animal{

	@Override
	public void sound() { // 추상메소드의 구현부를 만들어야한다.
		System.out.println("야옹야옹");
	}

}
