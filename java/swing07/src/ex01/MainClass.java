package ex01;

public class MainClass {
	public static void main(String[] args) {
		TimerThread th = new TimerThread();
		TimerThread th2 = new TimerThread();
		th.num = 1;
		th2.num = 100;
		th.delay = 1000;
		th2.delay = 2000;
		th.start(); // 새로운 실행 스택을 만들고 run을 실행한다.
		th2.start();
		System.out.println("main 종료");
		
	}

}
