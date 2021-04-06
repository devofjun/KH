package sec01.exam01;

// DmbCellPhone [is-a] CellPhone
// CellPhone: 부모클래스, 상위클래스, 슈퍼클래스 => 다 같은말
// DmbCellPhone: 자식클래스, 하위클래스, 서브클래스 => 다 같은말
public class DmbCellPhone extends CellPhone{
	// 필드
	int channel;
	// String model;
	// String color;
	
	// 생성자
	public DmbCellPhone(String model, String color, int channel) {
		super(); // 생략가능
		this.model = model;
		this.color = color;
		this.channel = channel;
	}
	
	// 메소드
	//DMB On
	void turnOnDmb() {
		System.out.println("채널 "+channel+"번 DMB 방송수신을 시작합니다.");
	}
	//Change DMB Channel
	void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널 "+channel+"번으로 바꿉니다.");
	}
	//DMB Off
	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}
}
