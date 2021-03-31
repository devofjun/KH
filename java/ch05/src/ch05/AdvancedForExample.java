package ch05;

public class AdvancedForExample {

	public static void main(String[] args) {
		int[] scores = {95,71,84,93,87};
		int sum = 0;
		// 대상(배열)의 원소의 처음~끝까지 차례로 추출
		for(int ascore : scores) { // scores에서 하나씩 빼내서 ascore에 담는다.
			sum += ascore;
		}
		System.out.println("점수 평균:"+(double)sum/scores.length);
	}

}
