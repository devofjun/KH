package phonebook;

public class PhoneBookMain {
	public static void main(String[] args) {
		PhoneInfo info1 = new PhoneInfo("김민영");
		info1.setPhoneNumber("010-1212-2323");
		PhoneInfo info2 = new PhoneInfo("김범민","010-1234-5678");
		info1.showInfo();
		info2.showInfo();
		
	}
}
