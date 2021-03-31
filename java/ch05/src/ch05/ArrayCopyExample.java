package ch05;

public class ArrayCopyExample {
	public static void main(String[] args) {
		int[] scores = {10,20,30};
		int[] newScores = new int[6];
		System.arraycopy(scores, 0, newScores, 0, 3);
		for(int i=0; i<newScores.length;i++) {
			System.out.println(newScores[i]);
		}
		
	}
}
