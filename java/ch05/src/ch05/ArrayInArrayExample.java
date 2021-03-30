package ch05;

public class ArrayInArrayExample {
	public static void main(String[] args) {
		/*
		int[][] array = 
			{
				{1,2},
				{3,4},
				{5,6},
				{7,8}
			};
		System.out.println(array.length); // 4개가 나온다.
		System.out.println(array); // 예상대로 주소가 나온다.
		System.out.println(array[0]); // c에서는 [0][0]를 줄여서 쓰이는것처럼 값이 나올 줄 알았지만 주소가 나온다.
		System.out.println(array[0][0]); // 1
		System.out.println(array[0].length); // 2개가 나온다.
		System.out.println(array[2][0]); // 5
		*/
		
		// 어떤 회사의 3년치 각 분기별 매출액
		int[][]	sales = new int[3][4];
		int sum = 0;
		for(int i=0; i<sales.length; ++i) {
			for(int j=0; j<sales[0].length; ++j) {
				sales[i][j] = 100 + (j*10);
				System.out.print("["+i+"]["+j+"]->"+sales[i][j]+" ");
				sum += sales[i][j];
			}
			System.out.println();
		}
		System.out.println("3년치 매출액: "+sum);
		System.out.println("3년치 매출 총액에 대한 연평균 매출: "+((double)sum / sales.length));
	}
}
