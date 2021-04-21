package ex02;

public class MainClass {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		/*
		System.out.println(cal.add(1, 2));
		System.out.println(cal.sub(1, 2));
		System.out.println(cal.mul(1, 2));
		System.out.println(cal.div(1, 0));
		System.out.println(cal.div2(1, 0));
		*/
		int[] arr = new int[5];
		try {
			for(int i=0; i<=arr.length;i++) {
				arr[i] = i + 1;
			}
		} catch (ArrayIndexOutOfBoundsException e) { 
			System.out.println("배열의 첨자가 범위를 벗어남");
		} finally { // 예외 발생 여부와 관계없이 무조건 실행됨.
			System.out.println("여기는 무조건 실행");
		}
		// catch는 발생될 수 있는 예외 타입에 따라서 여러개 작성할 수 잇음.
		// 모든 예외를 한곳에서 처리하겠다. -> 예외의 최상위 타입인 Exception으로 받아서 처리한다.
		System.out.println("종료");
	}
}
