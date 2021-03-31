package car1;

public class Car {
	//시동상태
	boolean power = false;
	//속도 velocity
	int speed = 0;
	//바퀴의 갯수
	int wheel = 4;
	//주행하기()
	void carDrive() throws Exception{
		if(speed<100 && power) {
			speed+=5;
			Thread.sleep(1000);
			System.out.println("현재 속도는 "+speed+"Km/h 입니다.");
		}
		else 
			System.out.println("악셀이 안먹혀!");
	}
	//멈추기()
	void carBreak() throws Exception{
		if(speed>0) {
			speed-=5;
			Thread.sleep(1000);
			System.out.println("현재 속도는 "+speed+"Km/h 입니다.");
		}
		else
			System.out.println("멈췄습니다.");
	}
	//시동상태()
	boolean pwCheck() {
		return power;
	}
	//시동확인()
	void pwChange() throws Exception{
		power = !power;
		if(power)
			System.out.println("시동이켜짐");
		else {
			System.out.println("시동이꺼짐");
			while(speed>0) {
				carBreak();
			}
		}
	}
	//속도확인()
	int spCheck() {
		return speed;
	}
}
