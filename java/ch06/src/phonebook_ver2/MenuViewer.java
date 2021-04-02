package phonebook_ver2;

import java.util.Scanner;

public class MenuViewer {
	static final int INPUT = 1;
	static final int SEARCH = 2;
	static final int EXIT = 3;
	static Scanner scan = new Scanner(System.in);
	
	public static void showTopMenu() {
		System.out.println("===전화번호부 ver2===");
	}
	
	
	public static int showStartMenu() {
		int choice = 0;
		showTopMenu();
		System.out.println("------------------");
		System.out.println("1.입력 2.조회 3.종료");
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
		PhoneInfo info = new PhoneInfo(name,number);
		System.out.println("-----입력완료-----");
		return info;
	}
	
	static String getSearchName() {
		System.out.print("이름>");
		String name = scan.nextLine();
		return name;
	}
	
	static void showExitMessage() {
		System.out.println("=====프로그램을 종료=====");
	}
	
}
