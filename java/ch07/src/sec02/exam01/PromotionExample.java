package sec02.exam01;

public class PromotionExample {
	public static void main(String[] args) {
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		// 상속 관계에서 하위 타입의 인스턴스를 상위 타입으로 형변환(자동)
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;
		
		B b1 = d;
		C c1 = e;
		
		//B b3 = e; // 아무 관계 없음
		
	}
}
