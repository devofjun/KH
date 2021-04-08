package sec03.exam01;

public class SmartPhone extends Phone{
	
	public SmartPhone(String owner) { // 상속받은 클래스에 정의된 생성자가 있기 때문에 매개 변수를 맞춰줘야함.
		super(owner);
	}
	
	public void internetSearch() {
		System.out.println("인터넷 검색");
	}
	public void show() {
		System.out.println("test");
	}
}
