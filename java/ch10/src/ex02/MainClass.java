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
		} finally {
			System.out.println("여기는 무조건 실행");
		}
		System.out.println("종료");
	}
}
