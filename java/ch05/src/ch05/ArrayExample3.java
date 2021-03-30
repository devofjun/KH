package ch05;

public class ArrayExample3 {
	public static void main(String[] args) {
		int[] scores = {83, 90, 87};
		int sum = add(scores);
		System.out.println(sum);
	}
	
	// method(메서드)
	public static int add(int[] arr) {
		System.out.println("add() 실행됨");
		int sum = 0;
		for(int i=0; i<arr.length;++i) {
			sum += arr[i];
		}
		return sum;
	}
}