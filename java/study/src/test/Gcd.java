package test;

public class Gcd { // greatest common divisor(최대공약수)
	public int result = 0;
	public static void main(String[] args) {
		int a = 28;
		int b = 30;
		int init = 1;
		for(int i=2; i<=Math.min(a, b); i++) { // 2부터 나누기
			while((a % i == 0)&&(b % i == 0)) {
				a = a / i;
				b = b / i;
				init *= i;
			}
		}
		System.out.println("최대공약수:"+init);
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		System.out.println("최소공배수:"+(init*a*b)); // Least common multiple(최소공배수)
	}
}
