package ch08;

public class USB implements IUsbPort{

	@Override
	public void sendData() {
		System.out.println("USB에서 보내기");
	}

	@Override
	public void receiveData() {
		System.out.println("USB에서 받기");
	}

}
