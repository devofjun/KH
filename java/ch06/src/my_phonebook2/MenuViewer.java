package my_phonebook2;

import java.util.Scanner;

public class MenuViewer {
	static final int INPUT = 1;
	static final int SEARCH = 2;
	static final int EXIT = 3;
	static final int ALL = 4;
	
	static Scanner scan = new Scanner(System.in);
	
	
	static void showTopMenu() {
		System.out.println("===내 전화번호부===");
	}
	
	static int showStartMenu() {
		int choice = 0;
		showTopMenu();
		System.out.println("------------------");
		System.out.println("1.입력 2.조회 3.종료 4.전체");
		System.out.println("------------------");
		System.out.print("선택>");
		choice = Integer.parseInt(scan.nextLine()); 			
		return choice;
	}
	
	static PhoneInfo getPhoneInfo() {
		System.out.print("이름>");
		String name = scan.nextLine();
		System.out.print("전번>");
		String number = scan.nextLine();
		return new PhoneInfo(name,number);
	}
	
	static String getSearchName() {
		System.out.print("이름으로 찾기>");
		return scan.nextLine();
	}
	
	static void showExitMessage() {
		System.out.println("프로그램을 종료합니다...");
	}
}
