package sec02.exam02;

public class ChildExample {
	public static void main(String[] args) {
		Child child = new Child();
		Parent parent = child;
		parent.method1();
		parent.method2();
		//parent.method3(); // parent로 바라보고 있어서  Parent에 없는 멤버는 지정할수없음.
		child.method1();
		child.method2();
		child.method3();
	}
}
