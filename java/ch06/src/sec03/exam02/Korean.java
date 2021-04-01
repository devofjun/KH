package sec03.exam02;

public class Korean {
		// 국적
		String nation = "대한민국"; 
		// 이름
		String name;
		// 주민번호 (Social Secret Number)
		String ssn;
		
		// 개발자가 생성자를 정의 -> 컴파일러가 기본생성자인 Korean()는 만들어주지 않는다.
		
		Korean(String n, String s){
			name = n;
			ssn = s;
		}
		
}
