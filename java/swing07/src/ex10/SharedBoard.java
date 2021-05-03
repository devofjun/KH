package ex10;

public class SharedBoard {
	int sum = 0;
	public int getSum() {
		return sum; 
	}
	// 동기화 = 먼저 사용하고 있던 Thread를 제외한 Thread는 기다리게 한다. 
	synchronized public void add() {
		int n = sum;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sum = n + 10;
	}
}
