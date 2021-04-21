package sec01.exam03;

public class ArrayIndexOutOfBoundsExceptionExample {
	public static void main(String[] args) {
		if(args.length == 3) {
			System.out.println("args: "+args[0]);
			System.out.println("args: "+args[1]);
			// 배열의 범위를 벗어난 예외 - ArrayIndexOutOfBoundsException
			System.out.println("args: "+args[2]);			
		} else {
			System.out.println("3개의 매개변수가 필요합니다.");
		}
		System.out.println("프로그램종료");
	}
}
