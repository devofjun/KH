package ch08;

public class ComputerCase implements IUsbPort{

	@Override
	public void sendData() {
		System.out.println("case에서 보내기");
	}

	@Override
	public void receiveData() {
		System.out.println("case에서 받기");
	}

}
