package test;

import java.util.Scanner;

public class Average {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("N:");
		int n = scan.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i=0; i<n; i++) {
			arr[i] = scan.nextInt();
			sum += arr[i];
		}
		System.out.println("avg:"+(double)sum/n);
	}
}
