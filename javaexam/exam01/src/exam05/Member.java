package exam05;

import java.util.Scanner;

public class Member {
	String name;
	String id;
	String pw;
	int age;
	Scanner scan = new Scanner(System.in);
	
	public Member() {
	}
	
	public Member(String name, String id, String pw, int age) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", pw=" + pw + ", age=" + age + "]";
	}
	
	public void login() {
		String ID = "";
		String PW = "";
		boolean idchk = false;
		boolean pwchk = false;
		
		while(true) {
			System.out.print("아이디 : ");
			ID = scan.nextLine();
			if(id.equals(ID)) {
				idchk = true;
				break;
			} else {
				System.out.println("아이디가 일치하지 않습니다. 다시 입력하세요.");
			}
		}
		while(true) {
			System.out.print("비밀번호 : ");
			PW = scan.nextLine();
			if(pw.equals(PW)) {
				pwchk = true;
				break;
			} else {
				System.out.println("비밀버호가 일치하지 않습니다. 다시 입력하세요.");
			}
		}
		if(idchk && pwchk) {
			System.out.println("로그인했습니다.");
		}
	}
	
}
