package test;

public class Test {

	public static void main(String[] args) {
		for(int i=1; i<5; i++) {
			for(int j=5; j>i; j--) {
				System.out.print(" ");
			}
			for(int a=1; a<=(i*2)-1; a++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

}
