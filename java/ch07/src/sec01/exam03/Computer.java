package sec01.exam03;

public class Computer extends Calculator{

	@Override // 오버라이드 된 메소드라는걸 명시하는 Annotation(어노테이션)
	double areaCircle(double r) {
		// TODO Auto-generated method stub
		return super.areaCircle(r);
	}
	/*
	double areaCircle(double r) {
		System.out.println("Computer");
		return Math.PI * r * r;
	}
	*/
	
}
