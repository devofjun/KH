package ex01;

public class TimerThread extends Thread{
	int num = 0;
	int delay = 0;
	@Override
	public void run() {
		int num = 0;
		while (true) {
			try {
				System.out.println(++num);
				Thread.sleep(delay);
				if(num >= 110) {
					break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		System.out.println("run 종료");
	}

}
