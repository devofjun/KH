package sample02;

public class WorkerMain {
	public static void main(String[] args) {
		// 업캐스팅 - 하위클래스의 타입을 상위 타입으로 바라봄
		Worker w1 = new Salesman();
		Worker w2 = new Programmer();
		Worker w3 = new Designer();
		Worker[] workers = {w1, w2, w3};
		//w1,w2,w3 <- Worker로 바라보고 있기 때문에 하위클래스만의 멤버는 접근 못함.
		for(Worker w : workers) {
			w.work();
		}
		
		// 다운캐스팅
		Salesman s1 = (Salesman)w1;
		Programmer p1 = (Programmer)w2;
		Designer d1 = (Designer)w3;
		s1.manageClient();
		p1.codeDebugging();
		d1.drawingLogo();
		
		//주의 : 다운캐스팅 = 원래의 타입
		//Designer d2 = (Designer)w1;
		//d2.drawingLogo();
		//컴파일은 문제 없지만 오류가 난다.
		
	}
}
