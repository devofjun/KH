package phonebook.ver4;

public class PhoneInfoUniv extends PhoneInfo{
	String major;
	
	public PhoneInfoUniv(String name, String number, String major) {
		super(name, number);
		this.major = major;
	}
	
	public String getMajor() {
		return major;
	}

	@Override
	public void showInfo() {
		System.out.println("이름: "+super.getName());
		System.out.println("전번: "+super.getNumber());
		System.out.println("회사: "+major);
		System.out.println("------------------");
	}
	
	
}
