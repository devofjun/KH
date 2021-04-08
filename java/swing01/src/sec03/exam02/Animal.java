package sec03.exam02;

// 추상메소드가 하나라도 있으면 추상클래스를 선언해야함.
public abstract class Animal {
	public String kind;
	
	public void breathe() {
		System.out.println("숨을 쉰다.");
	}
	// 추상메소드는 구현부가 없다.
	public abstract void sound();
}
