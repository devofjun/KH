package ch08;

public class MainClass {
	public static void main(String[] args) {
		// 인터페이스는 상위타입의 역할을 한다.
		IUsbPort[] ports = {
			new USB(), new ComputerCase()	
		};
		for(IUsbPort p : ports) {
			p.sendData();
			p.receiveData();
		}
	}
}
