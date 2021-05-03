package ex10;

public class SynchronizedEx {
	public static void main(String[] args) {
		SharedBoard board = new SharedBoard();
		StudentThread student1 = new StudentThread("가나다",board);
		StudentThread student2 = new StudentThread("라마바",board);
		student1.start();
		student2.start();
	}
}
