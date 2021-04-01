package sec04.exam02;

public class ComputerExample {
	public static void main(String[] args) {
		Computer com1 = new Computer();
		int[] values1 = {1,2,3};
		int result1 = com1.sum1(values1);
		System.out.println(result1);
		
		System.out.println(com1.sum2(1,2,3));
	}
}
