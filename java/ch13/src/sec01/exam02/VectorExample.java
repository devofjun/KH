package sec01.exam02;

import java.util.List;
import java.util.Vector;

public class VectorExample {
	public static void main(String[] args) {
		// Vector도 리스트 계열 -> List 인터페이스를 구현한 클래스
		// ArrayList와의 차이 : Vector는 Thread 에 안전
		List<Board> list = new Vector<>(); //<>를 생략하면 앞에 형식으로 자동으로 맞춰진다.
		for(int i=1; i<=5; i++) {
			list.add(new Board("제목"+(i),"내용"+(i),"작성자"+(i)));			
		}
		// 특정 위치에 데이터제거(remove)
		// 2번째 인덱스의 데이터는 삭제
		// 2번 이후 인덱스의 데이터는 한자리씩 당겨짐(자동)
		list.remove(2); // 삭제
		for(Board b : list) {
			System.out.print(b.subject + " | ");
			System.out.print(b.content + " | ");
			System.out.println(b.writer);
		}
	}
}


class Board {
	String subject;
	String content;
	String writer;
	// 필드 생성자
	public Board(String subject, String content, String writer) {
		super();
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}	
}