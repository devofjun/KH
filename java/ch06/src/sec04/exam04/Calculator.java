package sec04.exam04;

public class Calculator {
	// 더하기
	int plus(int x, int y) {
		return x + y;
	}
	// 평균 구하기
	double avg(int x, int y) {
		return (double)plus(x,y) / 2;
	}
	// 실행하기
	void execute() {
		System.out.println("실행결과: "+avg(7,10));
	}
	// 출력하기
	void println(String message) {
		System.out.println("실행결과: "+message);
	}
}
