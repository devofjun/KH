package sec04.exam03;

public class Car {
	int gas;
	// setter = 필드의 값을 설정하는 메서드
	void setGas(int gas) {
		this.gas = gas;
	}
	// gas가 남아 있는지 여부
	// tip: boolean 리턴타입의 메소드의 경우엔 이름앞에 'is' 나 'has'가 주로 온다.
	boolean isLeftGas() {
		if(gas==0) {
			System.out.println("gas가 없습니다.");
			return false;
		} else {
			System.out.println("gas가 있습니다.");
			return true;
		}
	}
	//
	void run() {
		while(true) {
			if(gas > 0) {
				System.out.println("달립니다. (gas잔량: "+gas+")");
				gas--;
			} else {
				System.out.println("멈춥니다. (gas잔량: "+gas+")");
				return;
			}			
		}
	}
}
