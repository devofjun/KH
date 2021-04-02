package sec04.exam02;

public class Computer {
	//배열을 인자로 받아서 처리
	int sum1(int[] values) { // 배열 한개
		int sum = 0;
		for(int i=0; i<values.length; ++i) {
			sum += values[i];
		}
		return sum;
	}
	// 복수형으로 받아서 처리
	int sum2(int...values) { // 정해진 개수가 없을 때
		int sum = 0;
		/*
		for(int i=0; i<values.length; ++i) {
			sum +=values[i];
		}
		*/
		System.out.println(values);
		for(int value : values) {
			sum += value;
		}
		return sum;
	}
}
