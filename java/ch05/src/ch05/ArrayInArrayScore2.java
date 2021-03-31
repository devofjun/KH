
package ch05;

import java.util.Scanner;

public class ArrayInArrayScore2 {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		String[] subject = {"국어","영어","수학"};
		// 학생수 입력 받기
		int students = inputStudents();
		int[][] scores = new int[students][3];
		// 점수 입력
		inputScores(scores,students,subject);
		// 학생당 평균
		showAvgStudent(scores,students,subject);
		// 과목당 평균
		showAvgSubject(scores,students,subject);
		scan.close();
	}//main
	
	//학생수 입력
	static int inputStudents() {
		System.out.print("학생수>");
		int students = scan.nextInt();
		return students;
	}
	
	// 점수 입력
	static void inputScores(int[][] scores, int students, String[] subject) {
		for(int i=0;i<students;++i) {
			for(int j=0;j<subject.length;++j) {
				System.out.print((i+1)+"번째 학생, "+subject[j]+"> ");
				//System.out.println(scores[i][j]);
				int a = scan.nextInt();
				scores[i][j] = a;
			}
		}
	}
	
	//각 학생의 평균
	static void showAvgStudent(int[][] scores, int students, String[] subject) {
		int sum = 0;
		for(int i=0;i<students;++i) {
			for(int j=0;j<subject.length;++j) {
				sum+=scores[i][j];
			}
			System.out.println((i+1)+"번째 학생의 평균 점수: "+((double)sum/subject.length));
			sum=0;
		}
	}
	//과목당 평균
	static void showAvgSubject(int[][] scores, int students, String[] subject) {
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
	}
}

