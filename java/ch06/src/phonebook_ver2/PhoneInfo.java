package phonebook_ver2;

public class PhoneInfo {
	String name;
	String number;
	
	PhoneInfo(String name){
		this.name = name;
	}
	PhoneInfo(String name, String number){
		this.name = name;
		this.number = number;
	}
	
	void setPhoneNumber(String number) {
		this.number = number;
	}
	void showInfo() {
		System.out.println("이름: "+name);
		System.out.println("전번: "+number);
		System.out.println("------------------");
	}
}
