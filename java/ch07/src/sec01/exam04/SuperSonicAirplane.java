package sec01.exam04;

public class SuperSonicAirplane extends Airplane{
	public static final int NORMAL = 1; // 보통모드
	public static final int SUPERSONIC = 2; // 초음속 모드
	
	public int flyMode = NORMAL; //현재 비행모드
	
	@Override
	public void fly() {
		if(flyMode == SUPERSONIC) {
			System.out.println("초음속 비행합니다.");
		} else {
			super.fly(); // 부모클래스에 있는 fly
		}
	}
}
