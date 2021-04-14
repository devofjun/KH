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
			System.out.print("���̵� : ");
			ID = scan.nextLine();
			if(id.equals(ID)) {
				idchk = true;
				break;
			} else {
				System.out.println("���̵� ��ġ���� �ʽ��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}
		while(true) {
			System.out.print("��й�ȣ : ");
			PW = scan.nextLine();
			if(pw.equals(PW)) {
				pwchk = true;
				break;
			} else {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}
		if(idchk && pwchk) {
			System.out.println("�α����߽��ϴ�.");
		}
	}
	
}
