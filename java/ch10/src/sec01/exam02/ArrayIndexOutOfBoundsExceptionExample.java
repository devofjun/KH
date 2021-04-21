package sec01.exam02;

public class ArrayIndexOutOfBoundsExceptionExample {
	public static void main(String[] args) {
		System.out.println("args: "+args[0]);
		System.out.println("args: "+args[1]);
		// 배열의 범위를 벗어난 예외 - ArrayIndexOutOfBoundsException
		System.out.println("args: "+args[2]);
	}
}
