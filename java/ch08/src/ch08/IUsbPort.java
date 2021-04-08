package ch08;

public interface IUsbPort {
	// 모든 필드가 public static final이다.(상수)
	public static final int SEND_SPEED = 10;
	public static final int RECEIVE_SPEED = 15;
	
	// public abstract 가 interface에서 default이다.
	public abstract void sendData();
	public abstract void receiveData();
}
