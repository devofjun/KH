package my_phonebook2;

import java.util.Scanner;

public class MenuViewer {
	Scanner scan = new Scanner(System.in);
	
	
	void showTopMenu() {
		System.out.println("==============");
		System.out.println(" 내 전화번호부  ");
		System.out.println("==============");
	}
	
	int showStartMenu() {
		int choice = 0;
		showTopMenu();
		System.out.println("------------------");
		System.out.println("1.입력 2.조회 3.종료");
		System.out.println("------------------");
		System.out.print("선택>");
		choice = Integer.parseInt(scan.nextLine()); 			
		return choice;
	}
	
	PhoneInfo getPhoneInfo() {
		System.out.print("이름>");
		String name = scan.nextLine();
		System.out.print("전번>");
		String number = scan.nextLine();
		return new PhoneInfo(name,number);
	}
}
