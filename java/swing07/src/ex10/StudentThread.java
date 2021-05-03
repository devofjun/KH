package ex10;

public class StudentThread extends Thread{
	SharedBoard board;
	public StudentThread(String name, SharedBoard board) {
		super(name);
		this.board = board;
	}
	
	@Override
	public void run() {
		for(int i = 0; i<10; i++) {
			board.add();
			int sum = board.getSum();
			System.out.println(this.getName() + ":" + sum);
		}
	}
	
}
