package phonebook.ver4;

public class PhoneInfoSocial extends PhoneInfo{
	private String company;

	public PhoneInfoSocial(String name, String number, String company) {
		super(name, number);
		this.company = company;
	}
	
	public String getCompany() {
		return company;
	}

	@Override
	public void showInfo() {
		System.out.println("이름: "+super.getName());
		System.out.println("전번: "+super.getNumber());
		System.out.println("회사: "+company);
		System.out.println("------------------");
	}

}
