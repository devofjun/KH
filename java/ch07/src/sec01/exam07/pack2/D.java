package sec01.exam07.pack2;

import sec01.exam07.pack1.A;

public class D extends A{
	// 다른 패키지에 있지만, 상속 관게에 있는 클래스에서
	// protected 에 접근해보기
	public D() {
		super();
		this.field = "value";
		this.method();
	}
}
