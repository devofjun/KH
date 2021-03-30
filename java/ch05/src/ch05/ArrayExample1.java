package ch05;

public class ArrayExample1 {
	public static void main(String[] args) {
		// 83,90,87 점에 대한 합계, 평균 구하기, 배열(array)
		int[] scores = {83, 91, 17, 73, 82};
		
		for(int i=0;i<scores.length;++i) {
			System.out.println("값"+i+": "+scores[i]);
		}

		
		int sum = 0;
		for(int i=0;i<scores.length;++i) {
			sum += scores[i];
		}
		System.out.println(sum);
		double avr = (double)sum / scores.length;
		System.out.println(avr);
	}
}
