package ch05;

public class ArrayExample2 {
	public static void main(String[] args) {
		// 배열도 객체다!! - 객체 - Heap - 해당 타입의 기본값으로 자동 초기화
		int[] arr1 = new int[3]; // -> 스택에 쌓이는 변수
		System.out.println("arr1:"+arr1);
		for(int i = 0; i < arr1.length; i++) {
			System.out.printf("arr1[%d]:%d\n",i,arr1[i]); // -> 0으로 초기화
		}
		
		// 실수형 배열 arr2 - 3개 짜리
		double[] arr2 = new double[3];
		System.out.println("arr2:"+arr2); // -> stack에 쌓이는 변수
		for(int i = 0; i < arr2.length; i++) {
			System.out.printf("arr2[%d]:%f\n",i,arr2[i]); // -> 0.0으로 초기화
		}
		
		// 문자열 배열 arr3 - 3개 짜리
		String[] arr3 = new String[3];
		System.out.println("arr3:"+arr3[0]); // -> Heap에 생성되는 참조형 변수
		for(int i = 0; i < arr3.length; i++) {
			System.out.printf("arr3[%d]:%s\n",i,arr3[i]); // -> String의 기본값인 null로 초기화 되어있다.
		}
		
		// MyBall 3개를 담을 배열 arr4를 정의
		MyBall[] balls = new MyBall[3]; // 현재 3개짜리 배열의 객체주소를 담을 변수를 만든 상태임. 절대 객체 하나하나가 만들어진것이 아님.
		System.out.println(balls);
		for (int i = 0; i < balls.length; i++) {
			balls[i] = new MyBall();
			System.out.println("balls[i]:"+balls[i]);
			System.out.printf("balls[%d].number:%d\n",i,balls[i].number); 
			System.out.printf("balls[%d].color:%s\n",i,balls[i].color);
		}
		// %d: decimal(10진 정수), %f: float(실수), %s: String(문자열)
	}
}

class MyBall {
	int number;
	String color;
}
