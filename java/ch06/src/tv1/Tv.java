package tv1;

public class Tv {
	boolean power = false;
	int channel = 0;
	int volume = 0;
//	전원
	void powerChange() {
		power = !power;
	}
//	전원상태확인
	void sayPower() {
		if(power == true) {
			System.out.println("전원켜짐");
		} else {
			System.out.println("전원꺼짐");
		}
	}
//	채널올리기
	void chUp() {
		if(power==true) {
			++channel;
		}
	}
//	채널 내리기
	void chDown() {
		if(power == true && channel>0) {
			--channel;
		}
	}
//	채널 변경
	void chChange(int n) {
		if(power == true)
			channel = n;
	}
//	채널값 확인
	void sayCh() {
		if(power == true)
			System.out.println("현재 채널: "+channel);
	}
//	볼륨올리기
	void voUp() {
		if(power == true)
			++volume;
	}
//	볼륨 내리기
	void voDown() {
		if(power == true && volume>0)
			--volume;
	}
//	볼륨값 확인
	void voCheck() {
		if(power == true)
			System.out.println("현재볼륨: "+volume);
	}
}
