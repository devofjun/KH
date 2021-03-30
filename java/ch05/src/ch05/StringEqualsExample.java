package ch05;

public class StringEqualsExample {
	public static void main(String[] args) {
		//  문자열 객체 vs 문자열 리터럴
		// "==" vs "equals()"
		
		// 문자열 리터럴(메모리에서 힙이 아닌 상수 영역에 정의됨)
		String strVar1 = "신민철";
		String strVar2 = "신민철";
		// 상수영역에 있는 같은 리터럴을 가리킨다.
		// 참조가 같은지 비교
		if(strVar1 == strVar2) {
			System.out.println("참조가 같음");
		} else {
			System.out.println("참조가 다름");
		}
		// 문자열이 같은지를 비교
		if(strVar1.equals(strVar2)) {
			System.out.println("문자열이 같음");
		} else {
			System.out.println("문자열이 다름");
		}
		
		// 문자열 객체
		String strVar3 = new String("이현승");
		String strVar4 = new String("이현승");
		
		// 참조가 같은지 비교
		if(strVar3 == strVar4) {
			System.out.println("참조가 같음");
		} else {
			System.out.println("참조가 다름");
		}
		// 문자열이 같은지를 비교
		if(strVar3.equals(strVar4)) {
			System.out.println("문자열이 같음");
		} else {
			System.out.println("문자열이 다름");
		}
	}
}
