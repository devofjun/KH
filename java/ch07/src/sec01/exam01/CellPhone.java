package sec01.exam01;

public class CellPhone {
	// 필드
	String model;
	String color;
	
	// 생성자
	
	// 메서드
	//전원켜기
	void powerOn() {
		System.out.println("Power On");
	}
	//전원끄기
	void powerDown() {
		System.out.println("Power Down");
	}
	//벨소리내기
	void bell() {
		System.out.println("벨을 울립니다.");
	}
	//음성보내기
	void sendVoice(String message) {
		System.out.println("자기: "+message);
	}
	//음성받기
	void receiveVoice(String message) {
		System.out.println("상대방: "+message);
	}
	//전화끊기
	void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
	
}
