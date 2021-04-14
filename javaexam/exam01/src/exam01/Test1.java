package exam01;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[3];
		//입력
		String[] str = {"첫번째 정수 : ", "두번째 정수 : ", "세번째 정수 : " };
		for(int i=0; i<3; i++) {
			System.out.print(str[i]);
			arr[i] = scan.nextInt();
		}
		//정렬
		int min = 99999999;
		for(int i=0; i<arr.length-1; i++) {
			for(int j=1; j<arr.length; j++) {
				if(arr[i]<arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		//출력
		
		System.out.println(arr[0]+">"+arr[1]+">"+arr[2]);
	}
}
