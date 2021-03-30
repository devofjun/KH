package ch05;

import java.util.Scanner;

public class ArrayInArrayScore {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 학생수 입력 받기
		System.out.print("학생수>");
		int students = scan.nextInt();
		int[][] scores = new int[students][3];
		String[] subject = {"국어","영어","수학"};
		
		// 점수 입력
		for(int i=0;i<students;++i) {
			for(int j=0;j<subject.length;++j) {
				System.out.print((i+1)+"번째 학생, "+subject[j]+"> ");
				scores[i][j] = scan.nextInt();
			}
		}
		
		// 학생당 평균
		int sum = 0;
		for(int i=0;i<students;++i) {
			for(int j=0;j<subject.length;++j) {
				sum+=scores[i][j];
			}
			System.out.println((i+1)+"번째 학생의 평균 점수: "+((double)sum/subject.length));
			sum=0;
		}
		
		// 과목당 평균
		int total = 0;
		double totalAvg = 0;
		for(int j=0; j<subject.length; ++j) {
			for(int i=0; i<students; ++i) {
				total+=scores[i][j];
			}
			totalAvg = (double)total/students;
			System.out.println(subject[j]+" 평균 : "+totalAvg);
			total = 0;
		}
		scan.close();
	}
}
