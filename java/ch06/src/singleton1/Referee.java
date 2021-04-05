package singleton1;

public class Referee {
	private static Referee instance;
	
	// 외부에서 new를 할 수 없게 만든다.
	private Referee() {	}
	
	// 보통 생성자를 private으로 막아놓고 함수로 생성자를 만들때는 getInstance라는 이름을 지음
	// static은 객체를 만들지 못하고 클래스이름으로 접근해야하기 때문에 넣음.
	public static Referee getInstance() {
		// 이렇게하면 객체를 하나만 존재하게 만들 수 있다.
		if(instance == null) {
			instance = new Referee();			
		}
		return instance;
	}
}
